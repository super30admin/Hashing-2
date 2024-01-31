import java.util.HashMap;
import java.util.Map;


// Time Complexity - O(N)
// Space Complexity - O(1) -> O(26)

// Constraints:
// 1 <= s.length <= 2000
// s consists of lowercase and/or uppercase English letters only.

public class LongestPalindrome {
    class Solution {
        public int longestPalindrome(String s) {
            int result = 0;
            Map<Character, Integer> freqMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }

            for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
                int currEntryFreq = entry.getValue();
                if (currEntryFreq % 2 == 0) {
                    result += currEntryFreq;
                } else {
                    result += currEntryFreq - 1; // 5 => Add 4
                }
            }

            if (result != s.length()) {
                result++;
            }

            return result;
        }
    }
}