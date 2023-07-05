#Time Complexity - O(N)
#Space Complexity - O(N)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        #optimal 
        c = {0:1}
        preSum = 0 
        cnt = 0 
        for i in range(len(nums)):
            preSum += nums[i]
            cnt += c.get(preSum - k, 0)
            c[preSum] = 1 + c.get(preSum , 0)
        return cnt