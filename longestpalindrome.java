// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: we are adding the character if it is not present. If it is already present
// we are incrementing the result by 2 and removing the character from the hashset. after the for loop we check if the hashset is empty. if it
// is not empty we increment the result by 1. 

// as to build the palindrome we should have each character twice front and end (even). and one character can be placed in the middle



class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> hset = new HashSet<>();
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            if(hset.contains(s.charAt(i)))
            {
                hset.remove(s.charAt(i));
                result = result+2;
            }
            else 
            {
                hset.add(s.charAt(i));
            }
        }
        if(!hset.isEmpty()) result++;
        return result;
    }
}