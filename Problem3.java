// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

import java.util.HashSet;

public class Problem3 {
    public int longestPalindrome(String s) {
       HashSet <Character> set = new HashSet<>();
       int count = 0;
       for(int i = 0; i < s.length(); i++){
           char c =  s.charAt(i);
           if(set.contains(c)){
               set.remove(c);
               count += 2;
           } else {
               set.add(c);
           }
       }
       if(!set.isEmpty()){
           count++;
       }
       return count;
    }
}
