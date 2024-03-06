# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        dict = {}
        dict[0] = 1
        count = 0
        rsum = 0

        for i in range(len(nums)):
            rsum += nums[i]
            y = rsum - k

            if y in dict:
                count += dict[y]
            if rsum not in dict:
                dict[rsum] = 1
            else:
                dict[rsum] = dict[rsum] + 1
        return count

sc = Solution()
nums = [1,1,1]
k = 2
print(sc.subarraySum(nums, k))