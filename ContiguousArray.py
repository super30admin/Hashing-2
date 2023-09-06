class Solution:
    def findMaxLength(self, nums):
        # Initialize variables
        max_length = 0
        cumulative_sum = 0
        sum_index_map = {0: -1}  # A dictionary to store cumulative sums and their indices
        
        # Iterate through the array
        for i in range(len(nums)):
            if nums[i] == 0:
                cumulative_sum -= 1
            else:
                cumulative_sum += 1
            
            # If the cumulative sum exists in the dictionary, update the max_length
            if cumulative_sum in sum_index_map:
                max_length = max(max_length, i - sum_index_map[cumulative_sum])
            else:
                sum_index_map[cumulative_sum] = i
        
        return max_length