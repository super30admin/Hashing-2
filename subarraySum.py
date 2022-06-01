class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
       
        prevSum = {}
        currentSum = 0
        prevSum[0] = 1
        counter = 0
        for num in nums:
            currentSum += num 
            if ((currentSum-k) in prevSum):
                counter+= prevSum[currentSum-k]
            prevSum[currentSum] = prevSum.get(currentSum, 0) + 1
        return counter
