# Time Complexity : O(n) where n is the length of the array
# Space Complexity : O(n) for storing cumulative sum indices in hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Transform the problem by treating 0s as -1 and 1s as +1, making it equivalent to finding longest subarray with sum 0.
# Use a hashmap to store the first occurrence index of each cumulative sum encountered.
# When the same cumulative sum appears again, calculate the length between current and stored index to find equal 0s and 1s.

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        sum_map = {0: -1}  # Initialize with sum 0 at index -1
        max_length = 0
        cumulative_sum = 0
        
        for i, num in enumerate(nums):
            # Treat 0 as -1 and 1 as +1
            cumulative_sum += 1 if num == 1 else -1
            
            # If this cumulative sum was seen before, calculate length
            if cumulative_sum in sum_map:
                max_length = max(max_length, i - sum_map[cumulative_sum])
            else:
                # Store first occurrence of this cumulative sum
                sum_map[cumulative_sum] = i
        
        return max_length

