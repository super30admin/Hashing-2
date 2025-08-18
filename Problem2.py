'''
Problem2 (https://leetcode.com/problems/contiguous-array/)
'''

class Solution:
    def findMaxLength(self, nums: List[int]) -> int: # type: ignore
        if nums == None or len(nums) == 0:
            return 0

        rSum = 0
        Map = {}
        Map[0] = -1 #rsum : idx
        maxLen = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                rSum = rSum - 1
            else:
                rSum = rSum + 1
            if rSum in Map:
                maxLen = max(maxLen, i - Map[rSum])
            else:
                Map[rSum] = i

        return maxLen                      