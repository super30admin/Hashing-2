package week2;

import java.util.HashMap;
import java.util.HashSet;

public class LongestPalindrome {

    public int longestPalindrome(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        boolean hasOdd = false;
        for(char c: str.toCharArray()) {
            int count = 0;
            if(map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        int count = 0;
        for(Integer freq : map.values()) {
            if(freq % 2 == 0) {
                count += freq;
            } else {
                count += freq - 1;
                hasOdd = true;
            }
        }
        return hasOdd ? count + 1 : count;
    }

    public int longestPalindromeSet(String str) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(char c: str.toCharArray()) {
            if(set.contains(c)) {
                count+=2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return !set.isEmpty() ? count + 1 : count;
    }

    public int longestPalindromeArray(String str) {
        char set[] = new char[100];
        int count = 0;
        for(char c: str.toCharArray()) {
            if(set[c - 'A'] != 0) {
                count+=2;
                set[c - 'A'] = 0 ;
            } else {
                set[c - 'A'] = c;
            }
        }
        if(str.length() == count) return count;
        return count + 1;
    }
}
