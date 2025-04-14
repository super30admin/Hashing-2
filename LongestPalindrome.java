// Count frequency of each character using a HashMap
// Add even frequencies directly to the palindrome length
// For odd frequencies, add (frequency - 1) to the length and set a flag
// If any odd frequency exists, add 1 at the end (center of the palindrome)
// Time : O(n), Space : O(k) where k is the number of unique characters
// this code worked on leetcode properly 

import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            // if(map.containsKey(c)) {
            //     map.put(c, map.get(c)+1);
            // } else{ // method 01
            //     map.put(c, 1);
            // }

            map.put(c, map.getOrDefault(c, 0)+1); // method 02
        }

        int count = 0;
        boolean flag = false;
        for(char c: map.keySet()) {
            int frq = map.get(c);
            if(frq % 2 == 0) { // even occurence
                count += frq;
            } else { // odd occurence
                count += frq - 1;
                flag = true;
            }
        }
        if(flag) return count+1;
        return count;
    }
}