// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
import java.util.HashSet;

class Problem3 {

    /** find longest palindrome combination */
    public int longestPalindrome(String s) {
       
        // using HashSet as we don't need values
       HashSet<Character> map = new HashSet<>();
       
       // iterate 
       for(int i=0;i<s.length(); i++){
           
           char x = s.charAt(i);
           
           // This condition is used to count character in set of two
           if(map.contains(x))
               map.remove(x);
           else
               map.add(x);
       }
       
       // if more than 1, single character are present in the map
       if(!map.isEmpty())
           return s.length() - map.size() + 1;
       // entire string is palindrome
       else
           return s.length();
       
   }
}