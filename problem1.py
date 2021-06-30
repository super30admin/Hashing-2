#Brute force
#time comp- O(n**2)
#space comp-O(1)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res=0
        for i in range(0,len(nums)):
            curr_sum=0
            for j in range(i,len(nums)):
                curr_sum=curr_sum+nums[j]
                if curr_sum==k:
                    res=max(res,j-i+1) # to take max value so far
        return res
                
