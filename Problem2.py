class Solution(object):
    def findMaxLength(self, nums):
        """
        The idea is to change all 0s to -1s and track the sum and index using hashmap. 
        if sum is already present in hashmap then update maxlength with current index - the value of hashmap where the sum was present
        :type nums: List[int]
        :rtype: int
        """

        for i in range(len(nums)):
            if(nums[i]==0):
                nums[i]=-1
        
        sum = 0
        maxLength = 0
        map={}
        map[0] = -1

        for i in range(len(nums)):
            sum+=nums[i]
            if sum in map:
                last = map.get(sum)
                maxLength = max(maxLength, i-last)

            else:
                map[sum] = i
        return maxLength