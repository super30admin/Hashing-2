// Time Complexity : TC = O(n) due to single pass
// Space Complexity : SC = O(52) at max 26 uppercase +26 lowercase chars stored
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Use a HashSet to store characters with odd frequencies.
//           Iterate through each character in the string:
//               - If the character is already in the set, remove it and add 2 to maxLength (indicating a paired match)
//               - If not in the set, add it.
//           After the loop, if the set is not empty, add 1 to maxLength (to account for a center character in the palindrome).

import java.util.HashSet;

public class LongestPallindrome {
   public int longestPalindrome(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int maxLength = 0;
        for(char c: s.toCharArray()) {
            if(hashSet.contains(c)) {
                maxLength += 2;
                hashSet.remove(c);
            } else {
                hashSet.add(c);
            }
        }
        if(!hashSet.isEmpty()) {
            maxLength++;
        }
        return maxLength;
    }
    public static void main(String[] args) {
        LongestPallindrome lp = new LongestPallindrome();

        String s1 = "abccccdd";
        System.out.println("Longest palindrome length in \"" + s1 + "\": " + lp.longestPalindrome(s1));

        String s4 = "abc";
        System.out.println("Longest palindrome length in \"" + s4 + "\": " + lp.longestPalindrome(s4));

    }
}
