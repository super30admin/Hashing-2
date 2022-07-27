"""
 Time Complexity : O(N), where N is number of elements in array
 Space Complexity : O(N)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No


Problem 1: Contiguous Array, Given a binary array nums,
           return the maximum length of a contiguous subarray with an equal number of 0 and 1.
"""

class Solution:
    """
    using hashmap to store the running sum w.r.t its index
    """
    def findMaxLength(self, nums) -> int:
        rsum = 0
        sum_index_map = {0: -1}
        
        res = 0
        
        for i in range(len(nums)):
            if nums[i] == 1:
                rsum  += 1
            else:
                rsum -= 1
                
            if rsum in sum_index_map:
                res = max(res, i - sum_index_map[rsum])
                sum_index_map[rsum]
            
            else:
                sum_index_map[rsum] = i
                
        return res