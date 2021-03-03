class Solution:
    def longestPalindrome(self, s: str) -> int:
        S = set()
        size = 0

        for x in range(len(s)):
            ch = s[x]

            if ch in S:
                size += 2
                S.discard(ch)
            else:
                S.add(ch)

        if len(S) == 0:
            return size
        return size + 1