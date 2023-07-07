// Time Complexity : O(n)
// Space Complexity :O(1) coz of only 26 characters
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Form longest palindrome from the string

import java.util.HashSet;

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int count = 0;
        for(int i =0; i<s.length(); i++) {
            if(set.contains(s.charAt(i)))
            {
                count+= 2;
                set.remove(s.charAt(i));
            }else {
                set.add(s.charAt(i));
            }
        }
        
        if(!set.isEmpty()) count++;
        return count;
    }
}