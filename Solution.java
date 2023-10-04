// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach



import java.util.HashSet;

class Solution {
    public int longestPalindrome(String s) {

      HashSet<Character> set = new HashSet<>();
      int counter=0;

      /*  check if the char is already in hashset, if yes, increase counter by 2 and remove the char from hashset. If not add the char to hash set*/

      for(int i=0; i < s.length(); i++){

          char c = s.charAt(i);
          if(set.contains(c)){

            counter+=2;
            set.remove(c);
         } else {
             set.add(c);
         }
      }
// if the hashset is not empty, then there are char with out any repetetion, so increament the counter by 1 and return counter
     if(!set.isEmpty()){
         counter++;
     }

     return counter;
}
}