// ## Problem3 (https://leetcode.com/problems/longest-palindrome)

// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashSet;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        // if (s == null || s.length() < 1) return 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i)))
                set.remove(s.charAt(i));
            else
                set.add(s.charAt(i));
        }
        if (set.size() <= 1)
            return s.length();
        return s.length() - set.size() + 1;
    }

    public static void main(String[] args) {
        LongestPalindrome obj = new LongestPalindrome();
        String input = "abccccdd";
        System.out.println("Length of Longest posisble Palindrome: " + obj.longestPalindrome(input));
    }

}
