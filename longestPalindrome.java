// Time Complexity : O(n), where n is the length of the string.
// Space Complexity : O(1), since the set will have at most 256 elements.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Create a set to store the characters.
 * 2. Iterate through the string and check if the character is present in the set.
 * 3. If it is present, increment the count by 2 and remove the character from the set.
 * 4. If it is not present, add the character to the set.
 * 5. At the end, if the set is not empty, increment the count by 1.
 * 6. Return the count.
 */


class Solution {
    public int longestPalindrome(String s) {
        int len = s.length();
        boolean[] set = new boolean[256];
        int count = 0;

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (!set[ch - 'A']) {
                set[ch - 'A'] = true;
            } else {
                count += 2;
                set[ch - 'A'] = false;
            }
        }

        for (int i = 0; i < 256; i++) {
            if (set[i]) {
                return count++;
            }
        }

        return count;
    }
}