# Time Complexity : O(n)
# Space Complexity : O(1) as max 52 characters are stored
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : HashSet used to track characters that haven't formed a pair yet,
# Add 2 to the count when pair found and remove that char from the set.
# If set is not empty, we can put one in the center — so we add 1 to the total.

class Solution:
    def longestPalindrome(self, s: str) -> int:
        char_set = set()
        count = 0

        for ch in s:
            if ch in char_set:
                char_set.remove(ch)
                count += 2
            else:
                char_set.add(ch)

        if len(char_set) > 0:
            count += 1

        return count
