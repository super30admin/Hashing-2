'''
Hashing-2

Explain your approach in three sentences only at top of your code

Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
'''

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int: # type: ignore
        if nums == None or len(nums) ==0:
            return 0

        count = 0
        Map = {}
        Map[0] = 1
        rSum = 0
        for i in range(len(nums)):
            rSum = rSum + nums[i]
            if rSum - k in Map:
                count = count + Map[rSum - k]
            if rSum in Map:
                Map[rSum]  = Map[rSum] + 1
            else:
                Map[rSum] = 1
        return count              