import java.util.*;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int maxLength = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        }
        for (int freq : charFreqMap.values()) {
            maxLength += freq / 2 * 2;
            if (maxLength % 2 == 0 && freq % 2 == 1) {
                maxLength += 1;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));  // Output: 7
    }
}
