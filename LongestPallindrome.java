import java.util.HashSet;
import java.util.Objects;

/**
 * TC - O(n) where n is length of string
 * SC - O(1) - we are going to store alphabets are in hashset but since they are limited (countable)
 */
public class LongestPallindrome {
    public int longestPalindrome(String s) {

        if(Objects.isNull(s)) {
            return -1;
        }

        if (s.length() == 1) {
            return 1;
        }

        HashSet<Character> pallindromeCharSet = new HashSet();
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            char pallindromeChar = s.charAt(i);
            if (!pallindromeCharSet.contains(pallindromeChar)) {
                pallindromeCharSet.add(pallindromeChar);
            } else {
                pallindromeCharSet.remove(pallindromeChar);
                count += 2;
            }
        }

        return pallindromeCharSet.size() > 0 ? count + 1 : count;

    }
}
