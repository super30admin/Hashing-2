import java.util.*;

public class LongestPalindrome {
    // TC: O(N), where N is the number of chars in String s
    // SC: O(N), where N is the number of unique chars in String s
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int length = 0;
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                length += 2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        if (!set.isEmpty()) {
            length += 1;
        }
        return length;
    }
}
