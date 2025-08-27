//Time Complexity: O(n) because we are iterating over the nums array
//Space Complexity: O(1) because we are storing the ASCII characters (128 max)
//Did this code successfully run on Leetcode : Yes

//Approach: create a data member length to store the length of the longest palindrome
//create a hash set to maintain the characters seen so far
//a palindrome string is a string that reads the same forwards and backwards
//if we see a character again, it means we found a pair, pairs can be added to the length, remove the char from the hashset : O(1)
//if the set is not empty, we have characters which have 1 occurrence left unused, we will increase the length by 1
//visualize this: abccccdd -> a:1, b:1, c:4, d:2 -> all c's and d's can be used ccddcc reads the same forwards and backwards
//we can use either of a or b to increase the length, ccdadcc or ccdbdcc length = 7 (this is what the last if statement is doing)
import java.util.HashSet;
import java.util.Set;

/**
 * Finds the length of the longest palindrome that can be formed using the given string
 */
public class LongestPalindrome {

    /**
     *
     * @param s given string
     * @return  the length of the longest palindrome that can be formed using the given string
     */
    public int longestPalindrome(final String s) {
        int length = 0;
        final Set<Character> chars = new HashSet<>();

        for (char ch : s.toCharArray()) {
            if (!chars.contains(ch)) {
                chars.add(ch);
                continue;
            }
            length += 2;
            chars.remove(ch);
        }

        if (!chars.isEmpty()) length += 1;
        return length;
    }

    public static void main(String[] args) {
        final LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abccccdd")); //return 7
        System.out.println(longestPalindrome.longestPalindrome("abccdcbcaadb")); //return 11
    }
}
