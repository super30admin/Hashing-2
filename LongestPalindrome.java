// Time Complexity : O(N) -- as traversing the array once
/* Space Complexity : O(1) -- as in worst case need to store max
26 elements in the HashSet
*/ 
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : Had to go through the logic 
again which was discussed in class*/

/*Approach -
--Keep on adding characters into the hashset
--As we encounter an already present element remove that element 
and increment count by 2 as pair of element makes a palindrome
--At last check if the hashset is not empty - if not empty increment 
count by 1, this is to take into account the unpaired elements which 
can be placed at very center of a word still preserving it as palindrome
e.g. bbabb -- a is that single character 
*/ 

// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                count = count + 2;
            }else{
                set.add(s.charAt(i));
            }
        }
        if(set.isEmpty()) return count;
        count = count + 1;
        return count;
    }
}