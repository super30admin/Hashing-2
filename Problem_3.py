# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        pal = 0
        count = collections.Counter(s)
        for s in count.values():
            pal += s if ((s % 2) == 0) else (s - 1)
        odd = any(((s % 2) == 1) for s in count.values())
        return (pal + odd)