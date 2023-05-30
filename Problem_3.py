"""
Problem : 6

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

class Solution:
    def longestPalindrome(self, s: str) -> int:

        count=[0]*128

        for c in s:
            count[ord(c)]+=1
        ans=0
        for i in count:
            ans+=i//2*2
            if ans%2==0 and i%2==1:
                ans+=1
        return ans
