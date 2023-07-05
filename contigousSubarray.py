#Time Complexity - O(N)
#Space Complexity - O(N)
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hashMap = {0:-1}
        total = 0 
        res = 0 
        for i in range(len(nums)):
            if nums[i]:
                total+=1
            else:
                total-=1
            if total in hashMap:
                res = max(res, (i-hashMap[total]))
                
            else:
                hashMap[total] = i 
                
        return res
            