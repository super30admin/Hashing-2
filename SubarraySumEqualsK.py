'''
TC: O(n)
SC: O(n)
'''
from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        runningSumToCount = {}
        count, tot = 0, 0
        runningSumToCount[0] = 1
        for i, num in enumerate(nums):
            tot += num
            count += runningSumToCount.get(tot - k, 0)
            runningSumToCount[tot] = runningSumToCount.get(tot, 0) + 1
        return count
s = Solution()
print(s.subarraySum([1,1,1], 2))
print(s.subarraySum([1,2,3], 3))
print(s.subarraySum([3,4,7,2,-3,1,4,2,0,1], 7))