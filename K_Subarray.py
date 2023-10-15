#TC: O(N)
#SC: O(1)
class Solution:
    def subarraySum(nums:list[int],k:int)-> int:
        sumdict = {0:1}
        count = 0
        s = 0
        
        for num in nums:
            s+=num
            if s-k in sumdict:
                count+=sumdict[s-k]
            if s in sumdict:
                sumdict[s]+=1
            else:
                sumdict[s]=1
        return count             
        
        
print(Solution.subarraySum([3,4,7,2,-3,1,4,2],7))
