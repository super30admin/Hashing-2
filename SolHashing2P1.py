"""
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.
Time Complexity : O(N) where N = length of nums
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :
Yes. I felt like this is like if know you it, you know it!! 

Your code here along with comments explaining your approach
1. Use running sum approach. Calculate running sum, at each index, check if (current running sum - k) is the in look-up dict. if yes, then this means that subarray exists
that adds upto k. Therefore, add the value of this key from the dict, to the total number of desired subarrays so far. 
Value in the dict = frequency of number of subarrays with a running sum as rSum.
"""

from collections import defaultdict
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        rSum = 0
        rSumSubArrayToFreq = defaultdict(lambda: 0)
        rSumSubArrayToFreq[0] = 1
        for i in range(len(nums)):
            rSum += nums[i]
            if rSum - k in rSumSubArrayToFreq:
                count += rSumSubArrayToFreq[rSum - k]
            rSumSubArrayToFreq[rSum] += 1
        return count