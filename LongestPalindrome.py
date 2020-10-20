#Time Complexity : O(n) where n is the length of input string
#Space Complexity : O(1) as the dictionary can be of max size 52 (26 lower case and 26 upper case letters)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def longestPalindrome(self, s: str) -> int:
        if not s:
            return 0

        counts = collections.Counter(s)

        longestPalindrome = 0
        odd = False
        for key, value in counts.items():
            if value % 2 == 0:
                longestPalindrome += value
            else:
                longestPalindrome += value-1
                odd = True

        return longestPalindrome + 1 if odd else longestPalindrome
