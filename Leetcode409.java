import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode409
 */
public class Leetcode409 {
    public int longestPalindrome(String s) {
        if (s.length() == 1)
            return 1;

        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
            } else {
                set.remove(ch);
                count += 2;
            }
        }
        if (!set.isEmpty())
            count += 1;

        return count;
    }

}

// time complexity=O(n)
// space complexity=O(1)