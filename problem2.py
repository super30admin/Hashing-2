# https://leetcode.com/problems/contiguous-array/

# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

from typing import List


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        table = {0 : -1}    # Prefix Sum and Index
        count, result = 0, 0
        for i in range(0, len(nums)):
            if nums[i] == 1:
                count += 1
            else:
                count -= 1
            if count not in table:
                table[count] = i
            else:
                result = max(result, i - table[count])
        return result