"""
## Problem2 (https://leetcode.com/problems/subarray-sum-equals-k/)
Time Complexity : 
Space Complexity : 

Did this code successfully run on Leetcode : Yes

Your code here along with comments explaining your approach:
Brute Force approach: Create all the subArrays and check if the sum of the elements in the subArray is equal to k. (Time Complexity: O(n^2) where n is the number of elements in the nums)

Implemented Solution's Approach:
1. Declare variables runningSum and count and initalialized to 0. Also, declare hashMap and insert (0,1) 
2. Loop through the nums. First calculate runningSum and check if runningSum - k is present in hashMap:
    - If it is present, then increase the count by hashMap[runningSum - k]
    - Else, add the runningSum in hashMap with its count as 1
3. At the end return count

"""


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hashMap = {}
        runningSum = 0
        count = 0

        hashMap[0] = 1

        for num in nums:
            runningSum += num
            if runningSum - k in hashMap:
                count += hashMap[runningSum - k]

            if runningSum in hashMap:
                hashMap[runningSum] = hashMap[runningSum] + 1
            else:
                hashMap[runningSum] = 1

        return count
