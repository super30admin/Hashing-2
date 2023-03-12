class Solution:
    # TC: O(n), SC: O(n)
    def findMaxLength(self, nums: List[int]) -> int:
        hashmap = {}
        hashmap[0] = -1
        runningSum = 0
        maxResult = 0
        for i in range(0,len(nums)):
            if nums[i] == 0:
                runningSum -= 1
            else:
                runningSum += 1
            if runningSum not in hashmap:
                hashmap[runningSum] = i
            else:
                maxResult = max(maxResult,i-hashmap[runningSum])
        return maxResult