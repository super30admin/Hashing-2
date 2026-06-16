# LEETCODE PROBLEM 525 CONTIGUOUS ARRAY
# TIME COMPLEXITY: O(N) where N is the number of elements
# SPACE COMPLEXITY: O(N) given that we need to initiate a hashmap for N elements 
# Any problem you faced while coding this: None

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        runningSum=0
        map={0:-1}
        result=0
        for i in range(len(nums)):
            if nums[i]==0:
                runningSum-=1
            else:
                runningSum+=1
            if runningSum in map:
                result=max(result,i-map[runningSum])
            else:
                map[runningSum]=i
        return result