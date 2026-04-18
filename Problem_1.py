## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)

class Solution:
    def subarraySum(self, nums, k):
        sum_map = {0:1}
        curr_sum = 0
        result = 0
        for n in nums:
            curr_sum += n
            if curr_sum - k in sum_map:
                result += sum_map[curr_sum - k]
            sum_map[curr_sum] = sum_map.get(curr_sum,0) + 1
        return result
    
nums = [1,2,3]
k = 3
sl = Solution()
print(sl.subarraySum(nums,k))
