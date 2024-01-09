## Problem2 (https://leetcode.com/problems/contiguous-array/)
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hashMap = dict()
        hashMap[0] = -1
        subSum = 0
        maxSubSum = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                subSum -= 1
            else:
                subSum += 1
            if subSum in hashMap:
                maxSubSum = max(maxSubSum, i - hashMap[subSum])
            else:
                hashMap[subSum] = i
        return maxSubSum

#In the bruteforce approach we will check every possible subarray which needs a nested loop but our present approach eliminates the nested loop
#we will follow z = x - y approach to calculate the subarray sums instead of looping
#it means we are using the existing values to find the subarray sums
#hashmap is maintained where key are the possible subarray sums, values are the first index of the sum formed
#time complexity O(n)
#space complexity O(n)