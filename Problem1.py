'''
https://leetcode.com/problems/subarray-sum-equals-k/

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

'''
'''
Time Complexity : O(N)
Space Complexity : O(N)
'''
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        '''
        create a hashmap 
        store the running sum and it's occurence in keyvalue pair
        check if present running sum-k is in hashmap 
        if yes then increment result and add +1
        else add running sum into hashmap with 1 as value
        return result
        '''
        hm = {}
        hm[0] = 1
        rsum = 0
        result = 0
        for i in range(len(nums)):
            rsum += nums[i]
            temp = rsum - k 
            if(temp in hm):
                result += hm[temp]
                
            if (rsum in hm):
                hm[rsum] += 1
            else :
                hm[rsum] = 1
        return result
            
                