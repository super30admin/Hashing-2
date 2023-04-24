
"""
## Problem2 (https://leetcode.com/problems/contiguous-array/)
Time Complexity : O(n^2) where n is the number of elements in nums
Space Complexity : O(1) No Auxillary Space is used

Did this code successfully run on Leetcode : Time Limit Exceeded

Your code here along with comments explaining your approach:
Brute Force approach: Create all the subArrays and check if they are balance by keeping a count of 0s and 1s in each subArray

"""


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        maxLength = 0

        for i in range(len(nums)):
            count0 = 0
            count1 = 0
            for j in range(i, len(nums)):
                if nums[j] == 0:
                    count0 += 1
                else:
                    count1 += 1

                if count0 == count1:
                    maxLength = max(maxLength, count0+count1)

        return maxLength
