class Solution:
    def longestPalindrome(self, s: str) -> int:
        res = set()
        count = 0
        for i in range(0, len(s)):
            if s[i] in res:
                count += 2
                res.remove(s[i])
            else:
                res.add(s[i])
        if len(res) > 0:
            count += 1
        return count