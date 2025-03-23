import java.util.*;

// Time Complexity: O(N), N is the length of the string
// Space Complexity: O(26) -> O(1) as there could be only
// Did this code successfully run on Leetcode: Yes 
// Any problem you faced while coding this: No
// Logic: Make pairs of character by adding HashSet, if the character already exists that you're trying to add then increment the count by 2. In last check if Hashset is empty or not, if yes then add 1 to count
class Solution {

    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int result = 0;
        // If the string is of length then that would be palindrome in itself
        if (s.length() == 1) return 1;
        // Loop over each character in string
        for (char chr : s.toCharArray()) {
            // if the set contains the character then remove it from set if it exists and 2 to count
            if (set.contains(chr)) {
                set.remove(chr);
                result += 2;
            } else {
                // Otherwise add character to HashSet
                set.add(chr);
            }
        }
        // Check if there is anything in HashSet 
        // If yes then add to result
        if (!set.isEmpty()) {
            result += 1;
        }

        return result;
    }
}
