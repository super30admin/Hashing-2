// Time Complexity : O(N)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashSet;

class Solution {
    public int longestPalindrome(String s) {

        HashSet<Character> set = new HashSet<>();

        int count=0;
        for (int i=0;i<s.length(); i++){
            char c= s.charAt(i);
            if(set.contains(c)){
                count+=2;//if we find the pairs make count +2
                set.remove(c);//remove it from set
            }
            else{
            set.add(c);
            }
        }
        if(!set.isEmpty()) count++;

        return count;

        
    }
}