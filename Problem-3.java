// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// Use a HashSet to track characters that appear an odd number of times while iterating through the string.
// Each time a duplicate is found, it forms a pair, so increment count by 2 and remove it from the set.
// At the end, if any character remains in the set, it can be placed in the middle of the palindrome → add 1 to count.

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> elements = new HashSet<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (elements.contains(c)) {
                count += 2;
                elements.remove(c);
            } else {
                elements.add(c);
            }
        }

        if (!elements.isEmpty()) {
            count += 1;
        }

        return count;
    }
}