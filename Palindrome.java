// Time Complexity : O(N), where N = length of String s
// Space Complexity : O(26) = O(1).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

class Solution {
    public int longestPalindrome(String s) {
        // Set to store what all chars has occurred
        Set<Character> set = new HashSet<>();
        
        int len = s.length();
        int count = 0;
        for(int i = 0; i < len; i++)
        {
            char ch = s.charAt(i);
            
            // If char is not present in set, add it
            if(!set.contains(ch))
            {
                set.add(ch);
            }
            else
            {
                // If it was; We can have palindrome of length 2.
                // So increase count by 2
                count += 2;
                // Remove char
                set.remove(ch);
            }
        }
        // If set is not empty That means we can use one char from set. So increase length by 1.
        if(set.isEmpty() == false)
        {
            count++;
        }
        
        return count;
        
    }
}