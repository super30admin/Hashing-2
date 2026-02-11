'''
https://leetcode.com/problems/subarray-sum-equals-k/


Time Complexity: O(n)
Space Complexity: O(n)
TIP:
You need to store dictionary as {runningSum: count} cuz you are tyring to count the occurence of the sum. which will give the total count
'''
class Solution:
    def subarraySum(self, nums: List[int], target: int) -> int:
        runningSumDict = {}
        runningSumDict[0] = 1 #edge case - refer to the video to understand the edge case
        runningSum = 0
        totalCount = 0
        
        for el in nums:
            runningSum += el
            complement = runningSum - target

            if  complement in runningSumDict:
                totalCount += runningSumDict[complement]

            if runningSum not in runningSumDict:
                runningSumDict[runningSum] = 1  
            else:
                runningSumDict[runningSum] += 1  
        
        return totalCount
            
        