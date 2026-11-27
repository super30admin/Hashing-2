#Time Complexity :O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes

#Use HashSet to track non pair chars.
#When we find a pair, we add 2 to the res and remove that char from the set.
#If set not empty, middle char- so we add 1 to res.

from collections import Counter
class Solution:
    def longestPalindrome(self, s: str) -> int:
        seen=set()
        res=0
        for c in s:
            if c in seen:
                res+=2
                seen.remove(c)
            else:
                seen.add(c)

        if len(seen):
            res+=1

        return res
        