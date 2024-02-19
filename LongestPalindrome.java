// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach - Palindrome can be constructed by two occurances of a character on either side and a single character in the center.

import java.util.HashSet;

class Solution {
    public int longestPalindrome(String s) {

        HashSet<Character> set = new HashSet<>();
        int charCount = 0;

        for (char ch : s.toCharArray()) {
            if (!set.contains(ch)) {
                set.add(ch);
            } else {
                charCount += 2;
                set.remove(ch);
            }
        }

        if (!set.isEmpty()) {
            charCount++;
        }

        return charCount;
    }
}
