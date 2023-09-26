#Time Complexity:O(N)
#Space Complexity:O(N)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if nums==None or len(nums)==0:
            return 0
        
        hashmap={}
        rsum=0
        total=0
        hashmap[rsum]=1

        for i in range(len(nums)):
            rsum =rsum + nums[i]
            if hashmap.get(rsum-k)!=None:
                total=total+hashmap[rsum-k]
            if hashmap.get(rsum)!=None:
                hashmap[rsum] +=1
            else:
                hashmap[rsum]=1
        return total
        