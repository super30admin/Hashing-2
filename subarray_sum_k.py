
# TC: O(n)
# SC : O(n)

class Solution:
    def subarraySum(self, nums: List[int], k: int) :
        hashmap = {}
        hashmap[0] = 1
        rSum = 0
        count = 0
        #i = 0
        for i in range(len(nums)):
           
            rSum += nums[i]
            # print("rSum :", rSum)
            # print("rSum complement :", rSum - k)
            if (rSum - k in hashmap):
                count += hashmap[rSum - k]
            if (rSum not in hashmap):
                hashmap[rSum] = 1
        
        
        return count
        
        
        
        