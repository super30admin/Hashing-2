// https://leetcode.com/problems/longest-palindrome/

// Time Complexity : O(n), we go ver the input once
// Space Complexity : Constant space, O(52) which is the 52 char set of upper and lower case characters stored in set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


// We can pair up all the elements with even count
// For odd count characters we can take the max number of pairs
// At the end, if there is an odd count character, we can add it to palindrome

import java.util.HashSet;
import java.util.Set;

class Problem1 {
    public int longestPalindrome(String s) {
        // We will keep track of pairs in hashset
        // and store the count in a variable
        Set<Character>  charSet=new HashSet<>();
        int count=0;
        for(Character c: s.toCharArray()){
            // Character not in set
            if(!charSet.contains(c))    charSet.add(c);
            else{
                // Character in set, we can make a pair
                charSet.remove(c);
                count+=2;
            }
        }

        // Check if an odd count character is still in set
        if(!charSet.isEmpty())    count+=1;
        return count;
    }
}