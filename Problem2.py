# https://leetcode.com/problems/contiguous-array/description/

# Time Complexity: O(n), first pass is to create rsum_list and second pass is on the rsum_list to create a hashmap 
# Space Complexity: O(1), a constant hashmap space

# This longest contiguous subarray problem implements the running sum. 
# Running sum is calculated by this logic - Increment the rsum if it is 1, else decrement if it's 0. A dictionary is created with every first occurence of the rsum. 
# Everytime we encounter a rsum which is already existing in dictionary, that means we have a valid contiguous subarray with equal 0's and 1's(balanced). 
# Balanced = When the difference between the curr rsum and previous rsum is 0(that means same rsum), then it's called balanced. 
# The length of balanced subarray is calculated using indexing and max is updated in every iteration until we get the longest. 
# We return the longest subarray length(which is also contiguous). The reason behind implementing with rsum is because we want to 
# check for a contiguous subarray. 
# 
# Example  [0, 1, 0,1,1,1,1,0,0,1,0,1,0,1,1,0,0,1,1] 
#           0  1  2 3 4 5 6 7 8 9 ................18
# rsum =   -1, 0,-1,0,1,2,3,2,1,2,1,2,1,2,3,2,1,2,3
# hm => rsum : idx = {-1 : 0, 0 : 1, 1 : 4, 2 : 5, 3 : 6}

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        rsum = 0
        hm = {}
        result = 0

        hm[0] = -1
        for i, num in enumerate(nums):
            if num is 0:
                rsum = rsum - 1
            else:
                rsum = rsum + 1

            if rsum not in hm:
                hm[rsum] = i
            else:
                result = max(result, i - hm[rsum])
                   
        return result 
    