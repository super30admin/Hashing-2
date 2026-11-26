# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#Approach: 1. Initialize the hashmap with rSum=0 to avoid missing out on the subarray with first occurance of rSum = 0.
#          2. Add the current num to the rSum and check if this rSum has occured before, if it has, that means that the subarrray between these two occurances sum up to 0, which reflects that the subarray in between these two indexes has equal number of 0s and 1s.
#          3. Update the maxLen if found, else, we just log the current rSum and the current index and return the maxLen at the end.


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        rSum = 0
        rSumMap = {0:-1}
        maxLen = 0

        for i, num in enumerate(nums):
            rSum += num if num == 1 else -1
            if rSum in rSumMap:
                maxLen = max(maxLen, i - rSumMap[rSum])
            else:
                rSumMap[rSum] = i
        return maxLen