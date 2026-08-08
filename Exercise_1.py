# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : The part that needed care was counting earlier prefix sums before adding the current one.
# Approach: I kept a running prefix sum while scanning the array once.
# If current_sum - k was seen before, every occurrence of that prefix forms a valid subarray ending here.
# Then I stored the current prefix sum so future positions can use it.


class Solution:

    def subarraySum(self, nums, k):
        prefix_counts = {0: 1}
        current_sum = 0
        count = 0

        for num in nums:
            current_sum += num
            needed = current_sum - k
            count += prefix_counts.get(needed, 0)
            prefix_counts[current_sum] = prefix_counts.get(current_sum, 0) + 1

        return count
