"""
TC: O(n)
Sc: O(1)
"""
from collections import defaultdict
class Solution:
    def longestPalindrome(self, str: str) -> int:
        _set = set()
        res = 0
        _dict = defaultdict(int)
        for s in list(str) : 
            if s in _set:
                _set.remove(s)
                _dict[s] += 2
            
            else:
                _set.add(s)
        
        res = sum(_dict.values())
        
        if len(_set) > 0:
            res += 1
        
        return res
