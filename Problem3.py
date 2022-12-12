T.C: O(n)
S.C: O(n)
class Solution:
    def longestPalindrome(self, s: str) -> int:
        if not s:
            return 0
        c = 0
        hashset = set()
        for ch in s:
            if ch not in hashset:
                hashset.add(ch)
            else:
                c += 2
                hashset.remove(ch)
        if hashset:
            c += 1
        return c
