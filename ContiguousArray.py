#Time Complexity : O(n^2) where n is the length of input array
#Space Complexity : O(1) 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Yes (the optimized version)

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        max_len = 0

        for i in range(len(nums)):
            zeroes, ones = 0, 0
            for j in range(i, len(nums)):
                if nums[j] == 0:
                    zeroes += 1
                else:
                    ones += 1

                if zeroes == ones:
                    max_len = max(max_len, j-i+1)

        return max_len
