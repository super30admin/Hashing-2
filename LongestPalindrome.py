# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to iterate each char in string and add to a list if the char is in list then remove it from list and add 2 to counter then 
# finally add 1 to counter since one character can be added to palindrome string.

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        d=[]
        c=0
        if(len(s)==1):
            return 1
        for i in s:
            if i in d:
                d.remove(i)
                c=c+2
            else:
                d.append(i)
        if(len(d)!=0):
            c+=1
        return c