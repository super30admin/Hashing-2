#Time Complexity : O(n)
#Space Complexity : O(1) 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def longestPalindrome(self, s: str) -> int:
        length = 0
        d = set()
        for c in s:
            if c in d:
                length += 2
                d.remove(c)
            else:
                d.add(c)
        
        return length + 1 if len(d) > 0  else length
