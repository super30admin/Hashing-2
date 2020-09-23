
class Solution:
    def longestPalindrome(self, s: str) -> int:
        p = 0
        u = set()

        for char in s:
            if char in u:
                p += 1
                u.remove(char)
            else:
                u.add(char)

        if u:
            return p * 2 + 1
        else:
            return p * 2