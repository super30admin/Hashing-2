/*409. Longest Palindrome
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.Letters are case sensitive, for example, "Aa" is not considered a palindrome.
Constraints:
1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
Example 1:
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

TimeComplexity:-O(n)
SpaceComplexity:-O(n)
Approach:- A palindrome allows characters to appear in pairs, with at most one odd character in the center.We use a HashSet to track characters:If a character repeats (i.e. already in set), we found a pair → +2 to length.
If not, add it to the set. After the loop, if the set isn’t empty, we can add 1 extra character in the center.
 */

import java.util.HashSet;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        // string is null case
        if (s == null || s.length() == 0) {
            return 0;
        }
        // To track unpaired characters
        HashSet<Character> set = new HashSet<>();
        int count = 0;// Tracks longest length of palindrome
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);// Current character
            if (set.contains(c)) {
                count = count + 2;// Found a pair
                set.remove(c);// Remove since it's now paired
            } else {
                set.add(s.charAt(i));// Add unpaired character
            }
        }
        if (!set.isEmpty()) {// One unpaired character can be used in the center
            count = count + 1;
        }
        return count;// Return max palindrome length
    }

}
