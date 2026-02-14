## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        r_sum = 0 
        hm = {
            0:1
        }
        count = 0
        for num in nums:
            r_sum += num 
            comp = r_sum - k
            if comp in hm:
                count+=hm[comp]
            if r_sum in hm:
                hm[r_sum]+=1
            else:
                hm[r_sum]=1
        return count