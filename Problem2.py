# Contiguous Array

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        #edge case where by default before begining the sum is 0 at index -1
        prefixSumMapToIndex = {0:-1}
        maxLength = 0
        runningSum = 0
        #use -1 for index 0 so it would make a diff in sum

        for i in range(0,len(nums)):
            num = nums[i]
            if num == 0:
                runningSum-=1
            else:
                runningSum+=1
            
            if runningSum in prefixSumMapToIndex:
                maxLength = max(maxLength, i-prefixSumMapToIndex[runningSum])
            else:
                prefixSumMapToIndex[runningSum] = i
        return maxLength

