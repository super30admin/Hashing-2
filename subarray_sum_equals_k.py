class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res=0
        cursum=0
        prefixSum= {0: 1} #Hashmap==> sum: count
        for n in nums:
            cursum+= n
            diff= cursum- k
            res+= prefixSum.get(diff, 0)
            prefixSum[cursum]= 1+ prefixSum.get(cursum, 0)
        return res