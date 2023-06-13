class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        runningSum = 0
        sumDict = {0: -1}
        maxLength = 0

        for i in range(len(nums)):
            if nums[i] == 0:
                runningSum -= 1
            else:
                runningSum += 1

            if runningSum in sumDict:
                length = i - sumDict[runningSum]
                maxLength = max(maxLength, length)
            else:
                sumDict[runningSum] = i

        return maxLength

