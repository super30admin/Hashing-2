# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        map={}
        map[0]=-1               #dummy Entry
        runningSum=0
        maxLength=0
        for i in range(len(nums)):
            if nums[i]==0:
                runningSum-=1
            else:
                runningSum+=1

            if runningSum not in map.keys():
                map[runningSum]=i
            else:
                prevIndexofRSum=map.get(runningSum)
                maxLength=max(maxLength,i-prevIndexofRSum)
                print(prevIndexofRSum+1,i) #start and end of the Contiguous Array

        return maxLength