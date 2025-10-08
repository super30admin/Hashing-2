import java.util.HashSet;

/**
 * Solution for LeetCode problem: Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome
 */
class LongestPalindrome {
    /**
     * Finds the length of the longest palindrome that can be built with the letters of the input string.
     * Uses a HashSet to track characters with odd counts.
     * For every pair found, adds 2 to the result. If any unpaired character remains, adds 1 to the result.
     */
    public int longestPalindrome(String s) {
        HashSet<Character> charSet = new HashSet<>();
        char[] chars = s.toCharArray();
        int result = 0;
        for (char c : chars) {
            if (charSet.contains(c)) {
                charSet.remove(c); // Found a pair, remove and add 2 to result
                result += 2;
            } else {
                charSet.add(c); // Add character if not paired yet
            }
        }
        if (!charSet.isEmpty()) result += 1; // Add 1 if any unpaired character remains
        return result;
    }

    /**
     * Alternative implementation using an array for uppercase letters only (A-Z).
     * Tracks odd/even counts for each character and calculates the palindrome length similarly.
     */
    public int longestPalindrome2(String s) {
        int[] charSet = new int[256]; // Array to track odd/even counts for A-Z
        char[] chars = s.toCharArray();
        int result = 0;
        for (char c : chars) {
            if (charSet[c- 'A'] == 1) {
                charSet[c- 'A'] = 0; // Found a pair, reset and add 2 to result
                result += 2;
            } else {
                charSet[c- 'A'] = 1; // Mark as odd occurrence
            }
        }
        for (int i : charSet){
            if(i == 1){
                result += 1; // Add 1 if any unpaired character remains
                break;
            }
        }
        return result;
    }
}
