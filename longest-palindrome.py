class Solution:
    def longestPalindrome(self, s: str) -> int:
        c_set = set()
        count = 0
        for c in s:
            if c not in c_set:  c_set.add(c)
            else: count+=2; c_set.discard(c)
        if c_set: count += 1
        return count