// Time Complexity :O(n )
// Space Complexity :o(1) - as we are using a set to store characters, the maximum size of the set can be 26 (for lowercase letters) or 52 (for both uppercase and lowercase letters), which is a constant.
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We can use a HashSet to keep track of characters we have seen.
// We iterate through each character in the string, and for each character,
//  we check if it in hashset , if we have already seen this character before,
//  it means we can form a pair of characters for our palindrome, 
// so we increment our count by 2 and remove the character from the set. 
// If we haven't seen the character before, we add it to the set. 
// After iterating through all characters, if there are any characters left in the set,
//  it means we can use one of them as the center of the palindrome, so we increment our count by 1.  and return the count as the length of the longest palindrome that can be formed with the given characters.

import java.util.HashSet;

class Solution {

    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count=0;

        for (char c : s.toCharArray()) {
        {
            if(set.contains(c))
            {
                count=count+2;
                set.remove(c);
            }
            else
            {
                set.add(c);
            }
        }
     
    }
       if(set.size()>0) count=count+1;
        return count;
    }
}