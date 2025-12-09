// https://leetcode.com/problems/longest-palindrome
/**
 * Approach: Palidrome can be like ccbaabcc or ccbakabcc.
 * All the letters will repeat even number of times and 1 letter can repeat odd number of times.
 * Use HashSet to store the characters. Iterate through each character of the string s.
 * If character is not present in the set, then add it.
 * If it is present, remove it and add 2 to the result.
 * This will cover even number of times scenario.
 * If there are any remaining characters in the set at the end, add 1 to the result.
 * This will cover odd number scenario.
 */
// Time complexity: O(N), where N = s.length().
// Space complexity: O(1) since a max of 52 entries can be stored in the set. 26 lowercase letters + 26 uppercase letters.

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestPalindrome(String s) {
        int result = 0;
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            // Check if ch is already present in the charSet
            if (charSet.contains(ch)) {
                // If present, add 2 to result and remove it from the charSet
                result += 2;
                charSet.remove(ch);
            } else {
                // If not present, add it to the charSet
                charSet.add(ch);
            }
        }
        // If there are any remaining characters in the charSet, add 1 to the result
        if (charSet.size() > 0) {
            result ++;
        }
        // Return result
        return result;
    }
}