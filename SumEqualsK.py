## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hashMap = {0:1}
        count = 0
        rSum = 0
        for i in nums:
            rSum += i
            complement = rSum - k
            if complement in hashMap:
                count += hashMap[complement]
            if rSum not in hashMap:
                hashMap[rSum] = 1
            else:
                hashMap[rSum] += 1
        return count

#we will follow z = x - y approach, but we will count the total subarrays based on the runningSum values
#Time complexity O(n)
#space complexity O(n)
