"""
TC: O(n)
SC: O(n)
"""
class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dict_ = {0:-1}
        currSum = 0
        maxLen = 0
        for i in range(0, len(nums)):
            currEle = 1 if nums[i] == 1 else -1
            currSum += currEle
            
            if currSum in dict_:
                idx = dict_[currSum]
                maxLen = max(maxLen, i -idx)
            else:
                dict_[currSum] = i 
        
        return maxLen
