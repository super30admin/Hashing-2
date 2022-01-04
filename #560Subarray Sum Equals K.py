#560 - Subarray Sum Equals K
# T.C => O(n)
# S.C => O(n)
# Approach = creating a dictionary with default value of 0 and count 1. then count the running sum which is differenctiated with the k value. 
# If the diffrentiated value is seen in running sum then remove the value of that running sum and add it to the count.

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if len(nums) == None: return 0
        #defining variables
        maps = {}
        counts = 0
        rSum = 0
        maps[0] = 1
        for i in range(0, len(nums)):
            rSum = rSum + nums[i]
            if (rSum - k) in maps:
                counts = counts + maps.get(rSum - k)
            if rSum in maps:
                val = maps.get(rSum)
                val += 1
                maps[rSum] = val
            else:
                maps[rSum] = 1
        print(maps)            
        return counts