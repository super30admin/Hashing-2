class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) <= 1: return len(s)
        res = set()
        count = 0
        for char in s:
            if char not in res:
                res.add(char)
            elif char in res:
                res.remove(char)
                count += 2
        if res:
            return count + 1
        return count



