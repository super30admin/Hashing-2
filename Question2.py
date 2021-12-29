# Time Complexity : O(n^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No. limit exceeded exception for most.
# Any problem you faced while coding this : Yes. optimal solution not found. Need to learn in class.
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        m = 0
        for i in range(len(nums)):
            zeros = 0
            ones = 0
            for j in range(i,len(nums)):
                if nums[j] == 0:
                    zeros += 1
                else :
                    ones += 1
                if zeros == ones:
                    m = max(m,j-i+1)
        return m
