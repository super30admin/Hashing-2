## Problem2 (https://leetcode.com/problems/contiguous-array/)

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def findMaxLength(nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        rSum = 0
        hMap = {0: -1}
        max_len = 0

        for num in range(len(nums)):
            if nums[num] == 1:
                rSum = rSum + 1
            else:
                rSum = rSum - 1

            if rSum in hMap:
                indexVal = hMap[rSum]
                max_len = max(max_len, (num - indexVal))
            else:
                hMap[rSum] = num

        return max_len

    nums = [0,1,0,1,1,1,0]
    print(findMaxLength(nums))