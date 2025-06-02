
# Implementation: Use a running count where 1 increments and 0 decrements, storing the first occurrence of each count in a hashmap to calculate the maximum length.
# Time Complexity: O(n), where n = len(nums), since we traverse the array once.
# Space Complexity: O(n), due to the hashmap storing up to n distinct count values.

from typing import List

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        index_map = {0: -1} 
        max_len = 0
        count = 0

        for i, val in enumerate(nums):
            count += 1 if val == 1 else -1

            if count in index_map:
                max_len = max(max_len, i - index_map[count])
            else:
                index_map[count] = i

        return max_len
