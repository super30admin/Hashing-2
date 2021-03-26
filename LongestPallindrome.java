
// Time Complexity : O(N)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int longestPalindrome(String s) {
        if(s==null || s.length() == 0){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
           int count = 0;
           for(int i = 0; i <s.length();i++){
               char c = s.charAt(i);
               if(set.contains(c)){
                   set.remove(c);
                   count += 2;
               }else{
                   set.add(c);
               }
           }
           if(set.size() > 0){
               count++;
           }
           return count;
    }
}