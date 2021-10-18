# Time Complexity: O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: ✔️
# Any problem you faced while coding this: Not sure if this is the most efficient solution


class Solution:
    def longestPalindrome(self, s: str) -> int:
        pairs = 0
        unpaired_chars = set()

        for char in s:
            if char in unpaired_chars:
                pairs += 1
                unpaired_chars.remove(char)
            else:
                unpaired_chars.add(char)

        return pairs * 2 + 1 if unpaired_chars else pairs * 2