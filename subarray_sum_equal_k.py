"""
# Time Complexity :
- O(n), where n is the length of the array

# Space Complexity :
- O(n), to store prefix sums in the hashmap

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
"""
from collections import defaultdict

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefix_sum_count = defaultdict(int)
        prefix_sum_count[0] = 1  # Base case: zero sum before array starts

        count = 0
        curr_sum = 0

        for num in nums:
            curr_sum += num
            if (curr_sum - k) in prefix_sum_count:
                count += prefix_sum_count[curr_sum - k]
            prefix_sum_count[curr_sum] += 1

        return count
