## Problem2 (https://leetcode.com/problems/contiguous-array/)

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        r_sum = 0
        max_length = 0 
        my_map = {
            0:-1
        }
        for i in range(len(nums)):
            if nums[i] == 0:
                r_sum-=1 
            else:
                r_sum+=1 

            if r_sum in my_map:
                max_length = max(max_length,i-my_map[r_sum])
            else:
                my_map[r_sum] = i 
        return max_length
