/*
* Approach:
*  1. Use hashset to pair the characters. 
        Insert characters into hashset. 
* 
*  2. If character is already present, we can pair them by:
        removing the character and incrementing the count by 2.
*     else
        just insert the character.
*  3. By the end of iteration of S, 
        we check hashset is empty or not,
            if yes, return count.
            else return count+1 (there are elements we cant be paired in hashset)
* 
    Alternate: we can also use boolean array of size 58 like hashset.
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n) -> single traversal
* 
* Space Complexity: O(1) -> max 52 keys
* 
*/
import java.util.HashSet;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> hset = new HashSet<>();

        int palindromeLength = 0;

        for (Character ch : s.toCharArray()) {
            if (hset.contains(ch)) {
                palindromeLength += 2;
                hset.remove(ch);
            } else {
                hset.add(ch);
            }
        }

        if (hset.size() != 0)
            palindromeLength++;

        return palindromeLength;
    }
}
