# Time Complexity - O(n)
# Space Complexity - O(n)
# Did it run on leetcode - Yes
# Did you face any problems - No
# Approach:
# - The number of subarrays that add upto a given sum can be represented as values to prefix sum keys
# - Initialize a map to hold prefix sums with 0:1 -> 1 subarray adds up to give prefix sum 0 (empty subarray)
# - Compute the prefix sums for every element
# - If k - prefix_sum exists in the map, this means we can achieve the given sum by adding the current element
# - Update the count of subarrays by 1
# - Update the value for the current prefix sum by 1 

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if not nums:
            return 0
        prefix_map = collections.defaultdict(int)
        prefix_sum = 0
        out = 0
        prefix_map[0] = 1
        for i in range(len(nums)):
            prefix_sum += nums[i]
            out += prefix_map[prefix_sum - k]
            prefix_map[prefix_sum] = prefix_map.get(prefix_sum, 0) + 1
        
        return out