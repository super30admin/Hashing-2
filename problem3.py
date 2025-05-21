"""
Approach: get all even lengths and 1 odd length for the mid element if possible
"""
class Solution:
    def longestPalindrome(self, s: str) -> int:
        counts = collections.defaultdict(int)
        for char in s:
            counts[char] += 1
        
        res = 0
        odd = 0
        for c, count in counts.items():
            if count % 2 == 0:
                res += count
            else:
                res += count - 1
                odd = 1
        return res + odd