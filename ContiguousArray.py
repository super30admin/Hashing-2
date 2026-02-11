# Time Complexity : O(n)
# Space Complexity : O(n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Increment sum for every 1 and decrement for every 0.
# If same runningSum is encountered again, that subarray between those indices is balanced.
# Track the longest subarray using hashmap.

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        runningSum, maxLen = 0, 0
        runningSumToIndex = {0: -1}

        for i, num in enumerate(nums):
            if num == 0:
                runningSum -= 1
            else:
                runningSum += 1

            if runningSum in runningSumToIndex:
                maxLen = max(maxLen, i - runningSumToIndex[runningSum])
            else:
                runningSumToIndex[runningSum] = i

        return maxLen

        