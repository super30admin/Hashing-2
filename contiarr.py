# Time Complexity : O(N) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Partially, 50 % of the test cases
# Any problem you faced while coding this : I didn't get the logic fully correct



class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        curr_sum = nums[0]
        max_sum = nums[0]
        for i in range(1, len(nums)):
            curr_sum = max(nums[i] + curr_sum, nums[i])
            max_sum = max(curr_sum, max_sum)
        return max_sum * 2