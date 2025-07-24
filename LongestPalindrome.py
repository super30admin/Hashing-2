# Time Complexity: O(n) * O(1) | n - iterating through the given array | 1 - iterating through set 
# Space Complexity: O(1) | to create set
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: NO

class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        chrSet = set()
        long_pal = 0

        for i in range(len(s)):
            char = s[i]

            if char not in chrSet:
                chrSet.add(char)
            else:
                chrSet.remove(char)
                long_pal += 2
        
        if len(s) == long_pal:
            return long_pal
        else:
            return long_pal + 1