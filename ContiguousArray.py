# Time Complexity : O(n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        n = len(nums)
        numsMap = {}
        numsMap[0] = -1
        maxLength = 0
        rsum = 0
        for i in range(n):
            if nums[i] == 0:
                rsum-=1
            else:
                rsum+=1
            if rsum in numsMap:
                maxLength = max(maxLength, i - numsMap.get(rsum))
            else:
                numsMap[rsum] = i
        return maxLength