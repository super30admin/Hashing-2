class Solution:
    def longestPalindrome(self, s: str) -> int:
        box = set()
        out = 0
        for i in s:
            if i in box:
                box.remove(i)
                out += 2
            else:
                box.add(i)
        out += 1 if box else 0
        return out
