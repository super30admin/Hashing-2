class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hMap = {0: -1}
        maxLen = 0
        rsum = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                rsum -= 1
            else:
                rsum += 1
            if rsum in hMap:
                maxLen = max(maxLen, i - hMap[rsum])
            else:
                hMap[rsum] = i
        return maxLen
