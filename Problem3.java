/*
 * Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)  
* 
* Space Complexity: O(1) ->  26 

Approach:
1. Use hashset for the characters
2.. If character is already present, we can pair them by, removing the character from hashset and incrementing the count by 2.
*     else
        just insert the character.
*3. In last iteration, 
If only the character is present increase the count by 1, else return count  */

class Solution {
    public int longestPalindrome(String s) {
        
        HashSet<Character> set = new HashSet<>();  //to store the characters
        int count = 0;

        for(int i=0; i< s.length(); i++)
        {
            char c = s.charAt(i);   //taking character in c
            if(set.contains(c))  //checking that character is present or not
            {
                count +=2;  //if yes, increase count by 2
                set.remove(c);  //and remove the character from hashset/
            }
            else{  //else add in hashset
                set.add(c);
            }
        }
        if(!set.isEmpty())  //is hashset is not empty 
        {
            count++;  //then incraese the count by 1
        }
        return count;
    }
}