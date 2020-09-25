
"""
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2
"""



class Solution:
def subarraySum(self, nums: List[int], k: int) -> int:
"""
Generate a running sum .
If running sum is equals k then increment count.
If running sum - k in hashmap take that particular value and add it to the count.
else put the running sum in hashmap 
"""
    # Runtime Complexity : O(N)
    # Space Complexity : O(N)
    hashmap = collections.Counter()
    running_sum = 0
    num_of_sub_arrays = 0
    for i in nums:
        running_sum += i
        if running_sum == k:
            num_of_sub_arrays += 1
        if running_sum - k in hashmap:
            num_of_sub_arrays += hashmap[running_sum-k] 
        hashmap[running_sum] += 1
    return num_of_sub_arrays