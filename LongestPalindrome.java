// Problem3 (https://leetcode.com/problems/longest-palindrome)

/**
 * Computes the length of the longest palindrome that can be built using the given characters.
 * Uses a HashSet to track character pairs, adding 2 to the count when a pair is found.
 * If any unmatched character remains, one can be placed in the center, increasing the count by 1.
 */

import java.util.*;

class LongestPalindrome {
    public int longestPalindrome(String s) {
        Set<Character> hset = new HashSet<>();
        int count = 0;

        for(char c : s.toCharArray()) {
            if(hset.contains(c)) {
                hset.remove(c);
                count +=2;
            }
            else {
                hset.add(c);
            }
        }
        if(!hset.isEmpty()) count ++;

        return count;
    }
}