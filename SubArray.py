# Time Complexity : O(n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        subMap = {}
        rsum = 0
        subMap[rsum] = 1
        result = 0
        for num in nums:
            rsum += num
            cmp = rsum-k
            if(cmp in subMap):
                result+=subMap.get(cmp)
            if rsum in subMap:
                subMap[rsum] = subMap.get(rsum)+1
            else:
                subMap[rsum] = 1

        return result