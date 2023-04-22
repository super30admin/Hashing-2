// Time Complexity : O(n) n is length of string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * we use hashmap to store character -> frequency and to get the longest palindrome we want to consider all occurences if its even,
 * and we want consider maximun even ocurrence from odd froquency that we could get, for this  we subtract "1" from the odd number
 * and we also maintain a variable to see if we have seen odd so far and add 1 if we have seen.
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if(s == null || s.length() < 1) { 
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            int count = 1;
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                count = map.get(c) + 1;
            }
            map.put(c,count);
        }
        boolean seenOdd = false;
        int longest = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if(value % 2 == 0) {
                longest = longest + value;
            } else {
                seenOdd = true;
                longest = longest + value - 1;
            }
        }
        longest = seenOdd ? longest + 1: longest;
        return longest;
    }
}

// Time Complexity : O(n) n is length of string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 *  Instead of using hashmap we can also solve this using hashset, where add character if seeing for the first time and 
 * remove it if set already contains the character along with adding 2 to the current count.
 * If hashset is not empty add 1 for the odd occurence.
 */

 class LongestPalindromeSet {
    public int longestPalindrome(String s) {
        if(s == null || s.length() < 1) {
            return 0;
        }
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                set.remove(c);
                count = count + 2;
            } else {
                set.add(c);
            }
        }
        count = set.isEmpty() ? count : count + 1;
        return count;
    }
 }