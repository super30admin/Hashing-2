#Brute force sol:
#Time comp-O(n**2)
#space comp-O(1)
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        res=0
        for i in range(0,len(nums)):
            c1=0
            c0=0
            for j in range(i,len(nums)):
                if nums[j]==0:
                    c0=c0+1
                else:
                    c1=c1+1
                if c1==c0:
                    res=max(res,c0+c1)
        return res
