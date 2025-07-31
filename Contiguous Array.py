class Solution(object):
    def findMaxLength(self, nums):
        prefix_map = {0: -1}  # Prefix sum to index; sum=0 starts at index -1
        max_len = 0
        prefix_sum = 0

        for i, num in enumerate(nums):
            # Convert 0 to -1 to apply prefix sum trick
            prefix_sum += -1 if num == 0 else 1

            if prefix_sum in prefix_map:
                # Found a subarray with equal 0s and 1s
                max_len = max(max_len, i - prefix_map[prefix_sum])
            else:
                # Store the first occurrence of this prefix sum
                prefix_map[prefix_sum] = i

        return max_len
