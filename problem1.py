
## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : the concept of searching "sum - k " in the dict is tricky
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count, sum = 0, 0
        d = {0:1}
        for i in range(len(nums)):
            sum += nums[i]
            if (sum-k) in d:
                count += d[sum-k]
                # print(d, sum-k, i)
            if sum in d:
                d[sum] += 1
            else:
                d[sum] = 1
            # print("d::",d)
        return count