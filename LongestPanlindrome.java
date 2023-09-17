// Time Complexity : O(n)
// Space Complexity : O(1) -- since only 26 alphabets
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/longest-palindrome/submissions/1048879313/
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

// If the count of the characters are even, then you’ll be able to return a maximum length palindrome with the count of even characters, else if there are odd number of characters then you’ll be able to add one extra to the existing palindrome length
// Use Hashset, add a character if it does not exist, else increment the count by 2 and remove character
// If hashset is not empty then increment the count by 1, and return count
import java.util.*;
class Solution {
    public int longestPalindrome(String s) {
        if(s==null || s.length() == 0){
            return 0;
        }
        int count = 0;
        HashSet<Character> hs = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(hs.contains(s.charAt(i))){
                count+=2;
                hs.remove(s.charAt(i));
            }
            else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()){
            count+=1;
        }
        return count;
    }
}
