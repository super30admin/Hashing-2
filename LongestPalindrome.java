// Given a string s which consists of lowercase or uppercase letters,
// return the length of the longest palindrome that can be built with those letters.

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this: no
//Approach:
// 1. Use hash set to store the char
// 2. If the char is present in set, remove it and increment the length by 2
// 3. At the end, if the set is not empty, it means there is odd length char, increment the len by 1

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
    private static int longestPalindrome(String s) {
        int maxLen = 0;
        Set<Character> charSet = new HashSet<>();

        for(char c : s.toCharArray()) {
            if (charSet.contains(c)) {
                maxLen += 2;
                charSet.remove(c);
            } else {
                charSet.add(c);
            }
        }

        // if the set is not empty, it means there is odd length char, increment the len by 1
        if(!charSet.isEmpty()) {
            maxLen += 1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd")); //7
        System.out.println(longestPalindrome("a"));   //1
        System.out.println(longestPalindrome("Aa")); //1
        System.out.println(longestPalindrome("BB")); //2
    }
}
