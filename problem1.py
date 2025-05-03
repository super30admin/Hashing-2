#subarray-sum-equals-k
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        runningSumDict = {0: 1}
        count = 0
        runningSum = 0
        for num in nums:
            runningSum += num
            complement = runningSum - k
            count += runningSumDict.get(complement, 0)
            runningSumDict[runningSum] = runningSumDict.get(runningSum, 0) + 1 
        return count