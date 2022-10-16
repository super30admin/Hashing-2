# // Time Complexity : O(n) because only once we iterate
# // Space Complexity : O(n) because hashMap can be created of size n, having n different prefixSums
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hashMap = collections.defaultdict(int)
        hashMap[0] = -1
        maxLen, prefixSum = 0, 0
        
        for i in range(len(nums)):
            if nums[i] == 0:
                prefixSum -= 1
            else:
                prefixSum += 1
            if prefixSum in hashMap:
                length = i - hashMap[prefixSum]
                maxLen = max(maxLen, length)
            else:
                hashMap[prefixSum] = i
        return maxLen