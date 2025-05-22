from collections import defaultdict
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        currentSum = 0
        sumMap = defaultdict(int)
        sumMap[0]+=1
        kSumCount = 0
        for i in range(len(nums)):
            n = nums[i]
            currentSum += n
            required = currentSum-k
            if required in sumMap:
                kSumCount += sumMap[required]
            sumMap[currentSum]+=1
        
        return kSumCount

