"""
# Time Complexity :
- O(n), single pass through the array

# Space Complexity :
- O(n), for storing prefix sums in a hash map

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
"""
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        count_map = {0: -1}  # Initialize count 0 at index -1
        max_len = 0
        count = 0

        for i, num in enumerate(nums):
            if num == 0:
                count -= 1
            else:
                count += 1

            if count in count_map:
                max_len = max(max_len, i - count_map[count])
            else:
                count_map[count] = i

        return max_len
