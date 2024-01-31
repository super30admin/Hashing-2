// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Approach: While iterating through each char of the input string, 
//Store the char encountered in hashset until its pair is found. 
//If the pair is found,remove the char from hashset and increment the counter by 2.
//By the end of the iteration if the hashset is not empty, increment the counter by 1.

public class Solution {
    public int LongestPalindrome(string s) {
        if(s == null) return 0;
        int maxLength = 0;
        HashSet<char> set = new HashSet<char>();
        for(int i = 0; i < s.Length; i++ ) {
            char ch = s[i];
            if(set.Contains(ch)) {
                maxLength += 2;
                set.Remove(ch);
            }
            else {
                set.Add(ch);
            }
        }
        if(set.Count > 0) {
            maxLength += 1;
        }

        return maxLength;
    }
}
