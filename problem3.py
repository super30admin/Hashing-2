# https://leetcode.com/problems/longest-palindrome/

# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


class Solution:
    def longestPalindrome(self, s: str) -> int:
        freq = {}
        for i in s:
            if i not in freq:
                freq[i] = 0
            freq[i] += 1

        flag = 0
        result = 0
        for i in freq.values():
            if i % 2 == 1:
                flag = 1
                result = result + i - 1
            else:
                result = result + i
        return result + flag
