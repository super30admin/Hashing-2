"""
Time - O(n)
Space - O(n)

"""

class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashset = set()
        result = 0

        for i in s:
            if i not in hashset:
                hashset.add(i)
            elif i in hashset:
                hashset.remove(i)
                result += 2
        
        if hashset:
            result += 1
        
        return result
        