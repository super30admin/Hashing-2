# Problem 1 - Subarray Sum Equals K (https://leetcode.com/problems/subarray-sum-equals-k/)
# Use a running prefix sum and hash map counting how many times each prefix sum has occured
# If current sum is rSum, then any previous prefix sum equal to (rSum - k) forms a subarray summing to k, so we add its count to the answer
# Initialize the map with {0:1} to count subarrays that start at index 0; iterate once for O(n) time and O(n) space
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if nums == None or len(nums) == 0:
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
                Map[rSum] = Map[rSum] + 1
            else:
                Map[rSum] = 1
        return count