/**
 * Approach:
 * - Use a HashSet to track characters with odd occurrences.
 * - For each character:
 *   - If already in the set, remove it and add 2 to the palindrome length (a pair is formed).
 *   - If not, add it to the set.
 * - After processing all characters, if the set is not empty,
 *   it means we can place one odd character in the middle, so add 1.
 * - Return the total length of the longest possible palindrome that can be formed.
 */

// Time Complexity : O(N), where N is the length of the string
// Space Complexity : O(1), since the set size is at most 52 for upper/lowercase letters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int length = 0;
        for (char c : s.toCharArray()) {
            // If character already seen, pair it and add 2 to length
            if (charSet.contains(c)) {
                charSet.remove(c);
                length += 2;
            } else {
                // Otherwise, mark character as unpaired
                charSet.add(c);
            }
        }
        // If any unpaired character remains, we can place one in the middle
        if (!charSet.isEmpty()) {
            length += 1;
        }
        return length;
    }
}
