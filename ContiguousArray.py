'''
TC: O(n)
SC: O(n)
'''
from typing import List

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        runningSumToIndex = {}
        tot, maxLength = 0, 0
        runningSumToIndex[0] = -1
        for i, num in enumerate(nums):
            tot = tot-1 if num == 0 else tot+1
            if tot not in runningSumToIndex:
                runningSumToIndex[tot] = i
            else:
                maxLength = max(maxLength, i-runningSumToIndex[tot])
        return maxLength
    
s = Solution()
print(s.findMaxLength([0,1]))
print(s.findMaxLength([0,1,0]))
print(s.findMaxLength([0,1,1,0,0,0,1,0,1,0,1,1,0]))
print(s.findMaxLength([1,1,0,0,0]))
print(s.findMaxLength([1,0,1,0,1,1,0]))