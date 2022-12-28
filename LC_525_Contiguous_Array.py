# TC - O(N)
# SC - O(N)

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        intMap = {0:-1} #Running Sum: Index
        result = 0
        rSum = 0

        for i in range(len(nums)):
            if nums[i] == 0:
                rSum = rSum -1
            else:
                rSum = rSum + 1

            if rSum in intMap:
                result = max(result, i-intMap[rSum])
            else:
                intMap[rSum] = i
        
        return result