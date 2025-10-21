import java.util.HashSet;
import java.util.Set;

/**
 * 409. Longest Palindrome
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * https://leetcode.com/problems/longest-palindrome/
 * 
 * This code uses hashset to keep track of characters with odd counts. When a
 * character is found again, it means we have a pair,
 * so we increment the count of pairs and remove the character from the set.
 * Finally, if there are any characters left in the set,
 * it means we can place one of them in the center of the palindrome, hence we
 * add 1 to the final length.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                count++;
                set.remove(c);
            } else
                set.add(c);

        }
        return set.size() > 0 ? count * 2 + 1 : count * 2;
    }
}
