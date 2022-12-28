# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No

def longestPalindrome(self, s):
        a=set()
        count=0
        for i in s:
            if(i in a):
                count+=2
                a.remove(i)
            else:
                a.add(i)
        if(a==set()):
            return count
        else:
            return count+1