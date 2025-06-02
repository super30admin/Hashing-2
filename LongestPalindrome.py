
# Implementation : Use a set to track characters, adding pairs when a duplicate is found and optionally one center character.
# Time Complexity: O(n), where n = len(s), since we traverse the string once.
# Space Complexity:O(1), msximum char is 52 which is constant

class Solution:
    def longestPalindrome(self, s: str) -> int:
        unmatched = set()
        length = 0

        for c in s:
            if c in unmatched:
                unmatched.remove(c)
                length += 2
            else:
                unmatched.add(c)
        if unmatched:
            length += 1

        return length
