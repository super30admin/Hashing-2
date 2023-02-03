"""
 Time Complexity : O(N), where N is number of elements in array
 Space Complexity : O(N)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No


Problem 1: Subarray Sum Equals K, Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
           A subarray is a contiguous non-empty sequence of elements within an array
"""
from collections import defaultdict

class Solution:
    def subarraySum(self, nums, k):
        """
        using hashmap to store the running sum w.r.t its frequency
        """
        rsum = 0
        sum_map = defaultdict(int)
        sum_map[0] = 1
        
        res = 0
        for i in range(len(nums)):
            rsum = rsum + nums[i]
            if (rsum-k) in sum_map:
                res  = res + sum_map[rsum-k]
                
            if rsum not in sum_map :
                sum_map[rsum] = 0
            
            sum_map[rsum] += 1
        
                
        return res