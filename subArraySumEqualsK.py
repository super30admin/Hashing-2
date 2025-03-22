# Time Complexity : O(n) where n is the length of the input string
# Space Complexity : O(n) where n is the length of the input string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# We use a hashmap to store the count of running sum (prefix sum).
# At each index, we calculate the running sum by adding the element to the total.
# If the difference between the total and k is in the hashmap, it means that there are hashmap[diff] number of subarrays that sum up to k. We increment the result by the count of the difference.
# We update the count of the running sum in the hashmap.

from collections import defaultdict
from typing import List
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # Initialize the hashmap to store the count of running sum
        prefixSum = defaultdict(int)
        res = 0
        prefixSum[0] = 1
        total = 0
        # Iterate through the input array
        for i in range(len(nums)):
            # Calculate the running sum
            total += nums[i]
            # Calculate the difference between the total and k
            diff = total - k
            # If the difference is in the hashmap, increment the result by the count of the difference
            if diff in prefixSum:
                res += prefixSum[diff]
            # Update the count of the running sum in the hashmap
            prefixSum[total] += 1
        return res