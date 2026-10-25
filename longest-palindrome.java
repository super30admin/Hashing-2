// Time Complexity : O(n) because we traverse the string once
// Space Complexity : O(n) for the HashSet storing unmatched characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
// We use a HashSet to track characters that have appeared an odd number of times.
// Whenever a character is already in the set, we remove it and add 2 to the palindrome length because it forms a pair.
// If any characters remain in the set, we add 1 to the length since one unmatched character can be placed at the center of the palindrome.

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                count += 2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }

        if (!set.isEmpty()) {
            count += 1;
        }

        return count;
    }
}