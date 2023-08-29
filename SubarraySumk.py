class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        freqMap = {0:1}
        count=0
        rSum=0
        for i in range(len(nums)):
            rSum+=nums[i]
            comp=rSum-k
            if comp in freqMap:
                count+=freqMap[comp]
            if rSum in freqMap:
                freqMap[rSum]+=1
            else:
                freqMap[rSum]=1
        
        
        
        return count