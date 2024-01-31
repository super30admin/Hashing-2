import java.util.HashSet;
import java.util.Set;

// Time Complexity - O(N)
// Space Complexity - O(1) -> O(26)

// Constraints:
// 1 <= s.length <= 2000
// s consists of lowercase and/or uppercase English letters only.

public class LongestPalindromeWithSet {
    class Solution {
        public int longestPalindrome(String s) {
            int result = 0;
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                char currChar = s.charAt(i);
                if (set.contains(currChar)) {
                    result += 2;
                    set.remove(currChar);
                } else {
                    set.add(currChar);
                }
            }

            if (!set.isEmpty()) {
                result++;
            }
            return result;
        }
    }
}