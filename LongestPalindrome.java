import java.util.HashSet;
import java.util.Set;

//Time Complexity: O(N) where N is the length of the characters
//Space Complexity: O(1) since the set can have 26 entries max
//Did this code successfully run on Leetcode : Yes

/**
 * Using the hashset to keep the track of characters which may be used in future when the same character shows up in the string. Character can be removed from set once the pair is found and we have used the pair to up our palindrome count
 * If there are any characters remaining at the end of finding all pairs, it can be used as middle character of the string for creating the palindrome
 */
public class LongestPalindrome {

    static private int longestPalindromeCount(String str) {
        int count = 0;
        Set<Character> chars = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (chars.contains(c)) {
                count += 2;
                chars.remove(c);
            } else {
                chars.add(c);
            }
        }

        if (!chars.isEmpty() && count != 0)
            count += 1;

        return count;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeCount("dabccdcbcaadb"));//11
        System.out.println(longestPalindromeCount("aaaaaaaaaaaaa"));//13
        System.out.println(longestPalindromeCount("aaaabaaaa"));//9
        System.out.println(longestPalindromeCount("abcdef"));//0
        System.out.println(longestPalindromeCount("a"));//1
        System.out.println(longestPalindromeCount("ab"));//1
        System.out.println(longestPalindromeCount(""));//0
    }
}
