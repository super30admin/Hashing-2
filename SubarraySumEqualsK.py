class Solution:
    def subarraySum(self, nums, k):
        # Initialize variables
        count = 0
        prefix_sum = 0
        prefix_sum_count = {0: 1}  # A dictionary to store prefix sums and their counts
        
        # Iterate through the array
        for num in nums:
            prefix_sum += num  # Calculate the prefix sum
            # Check if (prefix_sum - k) exists in the prefix_sum_count dictionary
            # If it does, it means there are subarrays with sum k ending at the current position
            if prefix_sum - k in prefix_sum_count:
                count += prefix_sum_count[prefix_sum - k]
            
            # Update the prefix_sum_count dictionary
            prefix_sum_count[prefix_sum] = prefix_sum_count.get(prefix_sum, 0) + 1
        
        return count

