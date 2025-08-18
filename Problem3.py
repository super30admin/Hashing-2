'''
Problem3 (https://leetcode.com/problems/longest-palindrome)
'''

class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = 0
        myset = set()
        for i in range(len(s)):
            c = s[i]
            if c in myset:
                count = count+2
                myset.remove(c)
            else:
                myset.add(c)    

        if myset:
            count = count+1

        return count           