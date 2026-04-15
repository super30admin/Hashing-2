#  Time Complexity : O(n)
#  Space Complexity : O(n) but can be considered O(1) as we are only storing max 52 characters in the set ( both upper and lower cases).
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : NA

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        charset=set()
        res=0

        for c in s:
            if c in charset:
                charset.remove(c)
                res+=2
            else:
                charset.add(c)

        if charset:
            return res+1
        return res