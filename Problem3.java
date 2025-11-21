// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
Traverse through the string while add the character in the hashSet.
If character already exists, increment the answer by 2 and remove it.
If result is same as string length, do not add 1, else add 1
 */

import java.util.*;

public class Problem3 {
    public int longestPalindrome(String s) {
        boolean[] charSet = new boolean[127];
        int result = 0;
        for(int i = 0;i<s.length();i++) {
            char ch = s.charAt(i);

            if(charSet[ch - 'A'] == true) {
                result += 2;
                charSet[ch - 'A'] = false;
            } else {
                charSet[ch - 'A'] = true;
            }
        }

        return result == s.length() ? result : result + 1;
    }

    public static void main(String[] args) {
        Problem3 solution = new Problem3();

        // Test cases
        String s1 = "abccccdd";
        String s2 = "a";
        String s3 = "aaabbb";
        String s4 = "Aa";

        System.out.println(solution.longestPalindrome(s1)); // Expected: 7
        System.out.println(solution.longestPalindrome(s2)); // Expected: 1
        System.out.println(solution.longestPalindrome(s3)); // Expected: 5
        System.out.println(solution.longestPalindrome(s4)); // Expected: 1 
    }
}