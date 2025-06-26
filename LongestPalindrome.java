/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindromic substring in s.
 * Approach:
 * 1. Count the occurrences of each character in the string.
 * 2. For each character, if its count is even, add it to the total length.
 * 3. If the count is odd, add the largest even part of that count to the total length and mark that we have at least one character with an odd count.
 * 4. If there is at least one character with an odd count, we can place one in the center of the palindrome.
 * 
 * * Time Complexity: O(n) where n is the length of the input string.
 * * Space Complexity: O(1) since we are using a fixed-size array for character counts (ASCII characters).
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] charCount = new int[128]; 
        for (char c : s.toCharArray()) {
            charCount[c]++;
        }

        int length = 0;
        boolean hasOddCount = false;

        for (int count : charCount) {
            if (count % 2 == 0) {
                length += count; // Add even counts directly
            } else {
                length += count - 1; // Add the largest even part of odd counts
                hasOddCount = true; // Mark that we have at least one odd count
            }
        }

        // If there's at least one character with an odd count, we can place one in the center
        return hasOddCount ? length + 1 : length;
    }
}
