#Time Complexity: O(n)
#Space complexity: O(n)

from typing import List

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0

        rSum = 0
        max_length = 0
        index_map = {0: -1} #[0, 1, 0, 1]

        for i in range(len(nums)):
            if nums[i] == 1:
                rSum += 1
            else:
                rSum -= 1
            
            if rSum in index_map:
                max_length = max(max_length, i - index_map[rSum])
            else:
                index_map[rSum] = i

        return max_length
