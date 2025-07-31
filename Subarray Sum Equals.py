class Solution(object):
    def subarraySum(self, nums, k):
        count = 0
        current_sum = 0
        prefix_map = {0: 1}  # Initialize with sum 0 occurring once

        for num in nums:
            current_sum += num

            # If (current_sum - k) seen before, add its count
            if current_sum - k in prefix_map:
                count += prefix_map[current_sum - k]

            # Update prefix_map with current_sum
            prefix_map[current_sum] = prefix_map.get(current_sum, 0) + 1

        return count
