// Longest Palindrome

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:  
//use a hashset of characters and add the characters ont by one. While adding check if the character is already present
//if yes, then increase the count by 2 and remove that character. In the end we check if the set is empty.
//If not then we increment the count by 1. eg: abccccdd  O/P : 7  Explaination : ccccdda/ccccddb




import java.util.HashSet;

class Solution {
    public int longestPalindrome(String s) {

        if (s==null) return -1;
        if(s.length()==1) return 1;

        HashSet<Character> set=new HashSet<>();
        int count=0;
        
        for(int i=0;i<s.length();i++)
        {
            char currChar=s.charAt(i);
            
            //We check if the character is already present
            if (set.contains(currChar))
            {
                //Increment the count by 2 and remove the character from the hashset
                count+=2;
                set.remove(currChar);
            }
            
            //If the character is not present in the hashset
            else 
            {
                set.add(currChar);
            }
            
        }
if(set.isEmpty()) return count;
else return count+1;
        
    }
}