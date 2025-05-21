# We use a hashmap to store the count of prefix sums seen so far while iterating through the array.
# For each element, we check if (current prefix sum - k) exists in the hashmap, which indicates a subarray summing to k.
# This allows us to count all such subarrays in a single pass with O(n) time complexity.

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        curr_sum = 0
        prefix_sums = {0: 1}
        for num in nums:
            curr_sum += num
            count += prefix_sums.get(curr_sum - k, 0)
            prefix_sums[curr_sum] = prefix_sums.get(curr_sum, 0) + 1
        return count
        