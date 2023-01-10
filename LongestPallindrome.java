// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach: We use a count variable and a hashset to store the characters. The idea is that the string is a pallindrome
// when all the characters are pairs except a middle element to the count would always be odd.
// We iterate through characters one by one, and add it to the hashset if not present.
// Since hashset cannot store duplicate values, if you come across a character already present in the hashset, we have found a pair
// and we increment the count. We then remove the character from the hashset.
// There could be one or more non-repeating characters in the hashset which could be the middle element of the pallindrome, so at the
// end we check if the hasset is not empty(since all pairs are counted and that character is removed from hashset) we increment count by 1.
// for the middle element.

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count=0;
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(set.contains(c)){
               count+=2;
                set.remove(c);
            } else{
                set.add(c);
            }
        }
        if(!set.isEmpty()){
            count++;            
        }        
        return count;
    }
    
}