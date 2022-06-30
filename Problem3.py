'''
409. Longest Palindrome
## Problem3 (https://leetcode.com/problems/longest-palindrome)

'''

'''
Time Complexity : O(N)
Space Complexity : O(N)
'''
class Solution:
    def longestPalindrome(self, s: str) -> int:
        '''
        Create a set and add element if not in set if it is in set 
        remove it and add +2 to result
        finally if hashset is empty return result
        else there are odd occurence elements so take 1 from it i.e add 1 to the result
        '''
        hs = set()
        res = 0 
        for i in s:
            if i in hs:
                res = res + 2
                hs.remove(i)
            else :
                hs.add(i)
        if(hs):
            return res + 1
        else :
            return res