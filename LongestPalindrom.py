class Solution:
    def longestPalindrome(self, s: str) -> int:
        d = set()
        count = 0
        for ch in s:
            if ch not in d:
                d.add(ch)
            else:
                d.remove(ch)
                count += 2
        
        if len(d) > 0:
            count += 1
        
        return count