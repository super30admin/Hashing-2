'''
409. Longest Palindrome
TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N) 
LEETCODE: Yes
Any Difficulty: No
'''

class Solution:
    def longestPalindrome(self, s: str) -> int:
        ln = 0
        m = {}
        for char in s:
            if char in m.keys():
                m[char] += 1
            else:
                m[char] = 1
        
        one_exists = False
        
        for k in m.keys():
            if m[k] % 2 == 0:
                ln += m[k] 
            elif m[k] == 1:
                one_exists = True
            else:
                ln += m[k] -1
                one_exists = True
                
        
        if one_exists:
            return ln + 1
        
        return ln
