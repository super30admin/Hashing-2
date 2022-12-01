// LONGEST PALINDROM

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>(); //Initialize set to keep a count of all the characters that have occurred
        int length = 0; //Initialize length to zero, we will keep incrementing this as and when we find pairs of characters
        for(int i = 0; i < s.length(); i++){ //Loop through the entire string
            char c = s.charAt(i); //Pick one character at a time
            if(set.contains(c)){ //Check if the same character has already occurred
                set.remove(c); //We have a pair now, so remove the character
                length += 2; //Increment the length of the longest palindrom, i.e., character at i plus the removed character
            } else {
                set.add(c); //If the character at ith index is not there in the set yet, we don't have a pair and it does not qualify yet to be in the palindromic string
            }
        }
        if(!set.isEmpty()) //We can have one odd character in the middle and have pairs of characters towards its left and right to form a palindrome. If there are more characters left in the set, then we can use up one of those characters and increment length by one
            length++;
        return length;
    }
}