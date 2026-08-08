# Time Complexity : O(n)
# Space Complexity : O(1), because letters are limited to a fixed character set.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I needed to add all even pairs while allowing only one odd character in the middle.
# Approach: I counted how many times each character appears.
# Every character contributes its largest even count to the palindrome length.
# If any character has an odd count, one extra character can be placed in the center.


class Solution:

    def longestPalindrome(self, s):
        counts = {}

        for char in s:
            counts[char] = counts.get(char, 0) + 1

        length = 0
        has_odd = False

        for count in counts.values():
            length += (count // 2) * 2

            if count % 2 == 1:
                has_odd = True

        if has_odd:
            length += 1

        return length
