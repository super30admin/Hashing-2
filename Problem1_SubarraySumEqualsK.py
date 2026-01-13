# Time Complexity : O(n) where n is the length of the array
# Space Complexity : O(n) for storing cumulative sums in hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use a hashmap to store cumulative sums and their frequencies as we iterate through the array.
# For each element, calculate the cumulative sum and check if (cumulative_sum - k) exists in the hashmap.
# If it exists, it means there are subarrays ending at current index with sum k, so add their count to result.

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        cumulative_sum = 0
        sum_map = {0: 1}  # Initialize with sum 0 having count 1
        
        for num in nums:
            cumulative_sum += num
            
            # Check if (cumulative_sum - k) exists in map
            if (cumulative_sum - k) in sum_map:
                count += sum_map[cumulative_sum - k]
            
            # Update the frequency of current cumulative sum
            sum_map[cumulative_sum] = sum_map.get(cumulative_sum, 0) + 1
        
        return count

