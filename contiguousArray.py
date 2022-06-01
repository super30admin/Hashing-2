class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        prevSum = {}
        prevSum[0] = -1
        rSum = 0
        maxLength = 0
        for idx in range(len(nums)):
            if (nums[idx] == 0):
                rSum -= 1
            else:
                rSum += 1
            
            if (rSum in prevSum):
                if maxLength < (idx - prevSum[rSum]):
                    maxLength = idx - prevSum[rSum]
            else:
                prevSum[rSum] = idx
        
        return (maxLength)
