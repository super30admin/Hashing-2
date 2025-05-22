class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        sumMap = {0:-1}
        value = {0:-1, 1:1}
        currentSum = 0
        maxlen = 0
        for i in range(len(nums)):
            currentSum += value[nums[i]]
            if currentSum in sumMap:
                l = i - sumMap[currentSum]
                if l > maxlen:
                    maxlen = l
            else:
                sumMap[currentSum] = i

        return maxlen

