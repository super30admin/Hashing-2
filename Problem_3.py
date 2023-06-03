"""
Problem : 6

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

class Solution(object):
    def longestPalindrome(self, s):
        hmap={}

        for i in s:
            if i in hmap:
                hmap[i]+=1
            else:
                hmap[i]=1
        
        odd=0
        maxlen=0

        for values in hmap.values():
            if values%2==0:
                maxlen+=values
            elif values%2==1:
            
                if values!=1:
                    maxlen+=values-1
                    odd=1
                else:
                    odd=1

        return maxlen+odd

