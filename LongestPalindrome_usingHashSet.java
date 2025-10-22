// Time Complexity : O(n) where n is the number of characters in the input string.
// Space Complexity : O(1) as the amount of space occupied in the hashset will be constant by all english letters.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Longest Palindrome
 * */

/*
 * Approach: Using HashSet
 * In this approach, add keep adding chars to the set until we find a pair. If we find a pairing duplicate element,
 * we remove it from the set and increment the result count by 2. At the end, if the set still contains more elements
 * it means that these are the element which did not pair with anything, so we can just use one character of those
 * to make it an odd numbered palindrome or else it will be an even numbered palindrome.
 * */

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome_usingHashSet {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;

        for (char ch: s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
                result += 2;
            } else {
                set.add(ch);
            }
        }

        if (set.size () > 0) result++;

        return result;
    }

    // Driver code
    public static void main(String[] args) {
        String s1 = "abccccdd";
        String s2 = "a";

        LongestPalindrome_usingHashSet longestPalindromeUsingHashSet = new LongestPalindrome_usingHashSet();
        System.out.println(longestPalindromeUsingHashSet.longestPalindrome(s1));
        System.out.println(longestPalindromeUsingHashSet.longestPalindrome(s2));
    }
}
