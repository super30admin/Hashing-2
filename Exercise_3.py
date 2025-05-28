# Problem #19 Longest Palindrome in a string
# #409 https://leetcode.com/problems/longest-palindrome/

# Author : Akaash Trivedi
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #702
# Any problem you faced while coding this : No

class Solution:
    def longestPalindrome(self, s: str) -> int:
        #set of characters
        charset = set()
        res = 0
        for c in s:
            if c in charset:
                res += 2
                charset.remove(c)
            else:
                charset.add(c)
        if charset:
            res +=1
        return res