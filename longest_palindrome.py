class Solution:
    def longestPalindrome(self, s: str) -> int:
        a = set()
        longest = 0

        for x in s:
            if x in a:
                longest += 2
                a.remove(x)
            else:
                a.add(x)

        if a:
            longest += 1
        return longest
