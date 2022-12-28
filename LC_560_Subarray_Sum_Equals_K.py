TC-O(N)
SC-O(N)
class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        intMap = {0:1}
        count = 0
        rSum = 0

        for i in range(len(nums)):
            rSum  = rSum + nums[i] #calculating running sum

#first check if the compliment exists
            if rSum-k in intMap:
                count = count + intMap[rSum-k]

#This is normal map input to maintain rSum and corresponding count
            if rSum not in intMap: 
                intMap[rSum] = 1
            else:
                intMap[rSum] = intMap[rSum] + 1

            

        return count