//Time Complexity : O(n)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

import java.util.HashSet;

/*
LC409- Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome
that can be built with those letters.
Letters are case-sensitive, for example, "Aa" is not considered a palindrome here.
Sol: When there is more than 1 occurrence of a letter, a palindrome can be built using it in edges. if there are more
chars with 1 occurrence, they can be in middle
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        //HashSet to store occurred chars
        HashSet<Character> set = new HashSet<>();
        int length = 0;
        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                length+=2; //2 chars on either corners of palindrome string
                set.remove(c);
            }
            else
                set.add(c);
        }
        if(!set.isEmpty())
            length++;

        return length;
    }

    public static void main(String args[]) {
        String s = "abccccdd";
        System.out.println("Length of longest palindrome is: " + new LongestPalindrome().longestPalindrome(s));
    }
}
