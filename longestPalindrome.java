// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class Solution {
    public static int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        
        int palindromeLength = 0;
        
        for (int i = 0; i < s.length(); i++) {

            if (set.contains(s.charAt(i))) {
                palindromeLength += 2;
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
            
        if (!set.isEmpty()) {
                palindromeLength += 1;
        }  
        
        return palindromeLength;
    }

    public static void main(String[] args) {
        String s = "hhhhhaaabbcdeaggg";
        int result;
        result = longestPalindrome(s);
        System.out.println(result);
    }
}
