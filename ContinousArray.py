# Time Complexity : It is O(n) since we are iterating with the word.
# Space Complexity : It is O(n) since are creating the hash map.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        maxLength =0 
        runningSum = 0
        valueIndexMap = {}
        valueIndexMap[runningSum]=-1
        for i in range(len(nums)):
            
            if nums[i] == 0:
                runningSum +=-1
            else:
                runningSum +=1
                
            if runningSum not in valueIndexMap:
                valueIndexMap[runningSum]=i
            else:
                maxLength=max(maxLength,i-valueIndexMap[runningSum])
        
        return maxLength
        
        
obj = Solution();
print(obj.findMaxLength([0,1]))
print(obj.findMaxLength([0,1,0]))
print(obj.findMaxLength([0,1,1,1,1,1,0,0,0]))