#Time Complexity:O(N)
#Space Complexity:O(N)

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if len(nums)==None or len(nums)==0:
            return 0
        hashmap={}
        Max=0
        rsum=0
        hashmap[rsum]=-1

        for i in range(len(nums)):
            num=nums[i]
            if num==0:
                rsum -=1
            else:
                rsum +=1

            if hashmap.get(rsum)!=None:
                Max=max(Max,i-hashmap[rsum])
            else:
                hashmap[rsum]=i
        
        return Max

        