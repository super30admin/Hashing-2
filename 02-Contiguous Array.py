# Problem 2 - Contiguous Array (https://leetcode.com/problems/contiguous-array/)
# Convert problem into tracking a running "balance" rSum where we treat 0 as -1 and 1 as +1
# A subarray has equal 0s and 1s exactly when the running sum at its ends is the same
# We store the earliest index at which each rSum value appears in a map so that when we see the same rSum again, the subarray between the first occurence and current index is balanced; we keep maximum such length in O(n) time
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        rSum = 0
        Map = {}
        Map[0] = -1 # rsum : idx
        maxLen = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                rSum = rSum - 1
            else:
                rSum = rSum + 1
            if rSum in Map:
                maxLen = max(maxLen, i - Map[rSum])
            else:
                Map[rSum] = i
        
        return maxLen