/*
Time Complexity: O(n)
- We iterate through the string once, and all operations on HashSet are O(1) on average.

Space Complexity: O(1)
- At most 52 characters (a-z, A-Z) in the HashSet, so space is constant.

Did this code successfully run on Leetcode:
- Yes
Approach:
- Use a HashSet to track characters that appear an odd number of times.
- When a duplicate is found, remove it from the set and add 2 to the result.
- If there's at least one unpaired character left at the end, add 1 to the result for the middle of the palindrome.
*/

class Solution {
    public int longestPalindrome(String s) {
        int ans = 0;
        HashSet<Character> set = new HashSet<Character>();
        
        // Traverse each character in the string
        for (int i = 0; i < s.length(); ++i) {
            char x = s.charAt(i);
            // If character x is already in the set, we've found a pair
            if (set.contains(x)) {
                set.remove(x); // Remove the paired character
                ans += 2;      // Add 2 to the palindrome length (for the pair)
            } else {
                set.add(x); // Otherwise, store the unpaired character
            }
        }

        // If there are any unpaired characters left, we can place one in the middle
        return set.isEmpty() ? ans : ans + 1;
    }
}


