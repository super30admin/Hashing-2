"""
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
Time Complexity : O(N) where N = length of nums
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :
Yes. I felt like this is like if know you it, you know it!! 

Your code here along with comments explaining your approach
1. Use running sum approach. Calculate running sum, at each index. But it uses a different approach, if nums[i] == 0, then rSum -= 1, if nums[i] == 1, rSum += 1
for the lookup we have a dict- key = rSum , val = earliest index to encounter a rSum. 
Since, the i/p = binary array, the balanced array lies between,
-1 to -1, 0 to 0, 1 to 1, so calculate the length between these values and then return the maxlengthSoFar of a balanced array.
"""

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        rSum = 0
        rSumToLowestIndex = {0: -1}
        maxSoFar = 0
        for i in range(0, len(nums)):
            if nums[i] == 0:
                rSum -= 1
            else:
                rSum += 1
            if rSum in rSumToLowestIndex:
                maxSoFar = max(maxSoFar, i - rSumToLowestIndex[rSum])
            else:
                rSumToLowestIndex[rSum] = i
        return maxSoFar