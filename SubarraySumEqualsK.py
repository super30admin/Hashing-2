# Problem: Subarray Sum Equals K (LeetCode 560)
# Time Complexity: O(n), where n = len(nums)
# Space Complexity: O(n), due to the hashmap storing up to n prefix sums.
# Implementation Thought: Use a running prefix sum and hashmap to count how many times each prefix sum appears.

from collections import defaultdict
from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        current_sum = 0
        prefix_counts = defaultdict(int)
        prefix_counts[0] = 1 
        
        for num in nums:
            current_sum += num
            if (current_sum - k) in prefix_counts:
                count += prefix_counts[current_sum - k]
            prefix_counts[current_sum] += 1

        return count
