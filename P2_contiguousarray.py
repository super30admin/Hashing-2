"""
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
## Problem2 (https://leetcode.com/problems/contiguous-array/)

# I figured if I treat 0s as -1s and track the earliest index where each count occurred all equal 0 and 1 will cancel each other out.

"""

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        count = 0
        max_len = 0
        seen = {0: -1}

        for i in range(len(nums)):
            count += 1 if nums[i] == 1 else -1
            if count in seen:
                max_len = max(max_len, i - seen[count])
            else:
                seen[count] = i

        return max_len
