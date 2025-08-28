// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach
// Iterate through the string and store characters in a hash set
// If character already exists in the hashset remove it and count the pair
// In the end check if set is empty to take one element for the center of the palindrome

import java.util.HashSet;

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        
        for(char ch : s.toCharArray()) {
            if(!set.contains(ch))
                set.add(ch);
            else {
                count += 2;
                set.remove(ch);
            }
        }
        if(!set.isEmpty())
            count++;
        
        return count;
    }
}