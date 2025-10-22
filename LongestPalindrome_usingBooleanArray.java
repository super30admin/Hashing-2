// Time Complexity : O(n) where n is the number of characters in the input string.
// Space Complexity : O(1) as the amount of space occupied in the bool array will be constant by all english letters.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Longest Palindrome
 * */

/*
 * Approach: Using Boolean Array as Set
 * In this approach, add keep setting bool values in set array until we find a pair. If we find a pairing duplicate element,
 * we set its value to false again and increment the result count by 2. At the end, if the string length and count does
 * not match it means there are some characters left which have not found a pair and so we increment result count by
 * one to form a max length palindrome.
 * */

public class LongestPalindrome_usingBooleanArray {
    public int longestPalindrome(String s) {
        boolean[] set = new boolean[95];
        int count = 0;

        for (char ch: s.toCharArray()) {
            if (set[ch - 'A']) {
                count += 2;
                set[ch - 'A'] = false;
            } else {
                set[ch - 'A'] = true;
            }
        }

        if (s.length() == count) return count;
        return count+1;
    }

    // Driver code
    public static void main(String[] args) {
        String s1 = "abccccdd";
        String s2 = "a";

        LongestPalindrome_usingBooleanArray longestPalindromeUsingBooleanArray = new LongestPalindrome_usingBooleanArray();
        System.out.println(longestPalindromeUsingBooleanArray.longestPalindrome(s1));
        System.out.println(longestPalindromeUsingBooleanArray.longestPalindrome(s2));
    }

}
