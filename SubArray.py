# Time Complexity : It is O(n) since we are iterating with the word.
# Space Complexity : It is O(n) since are creating the hash map.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        maxSubArrayCount =0
        sumofValues=0
        subArrayMap = {}
        subArrayMap[0]=1
        
        for i in range(len(nums)):
            sumofValues += nums[i]          
            if (sumofValues - k) in subArrayMap:
                maxSubArrayCount += subArrayMap[sumofValues - k]
            
            if(sumofValues not in subArrayMap):
                subArrayMap[sumofValues] =  1
            else:
                subArrayMap[sumofValues] = subArrayMap[sumofValues] + 1
            

        return maxSubArrayCount
            
        
obj = Solution();
print(obj.subarraySum([-1,-1,1],0))
print(obj.subarraySum([1,1,1],2))
print(obj.subarraySum([1,2,3],3))