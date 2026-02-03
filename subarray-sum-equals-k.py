''' 
Time Complexity : O(n)
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No

Approach : Calculate the Running Sum at each index.
'''

class Solution:
    # def subarraySum(self, nums: List[int], k: int) -> int:
    #     cnt = 0
    #     n = len(nums)
    #     for i in range(n):
    #         sm = 0
    #         for j in range(i, n):
    #             sm += nums[j]
    #             if sm == k:
    #                 cnt += 1

    #     return cnt
    # def subarraySum(self, nums: List[int], k: int) -> int:
    #     hashmap = {}
    #     hashmap[0] = 1
    #     cnt = 0
    #     rsum = 0
    #     for i in range(len(nums)):
    #         rsum += nums[i]
    #         if rsum - k in hashmap:
    #             cnt += hashmap.get(rsum - k)
            
    #         hashmap[rsum] = hashmap.get(rsum, 0) + 1

    #     return cnt
    def subarraySum(self, nums: List[int], k: int) -> int:
        cnt = 0
        hashmap = {}
        hashmap[0] = 1
        n = len(nums)
        rsum = 0
        for i in range(n):
            rsum += nums[i]
            if rsum - k in hashmap:
                cnt += hashmap.get(rsum - k)

            hashmap[rsum] = hashmap.get(rsum, 0) + 1
        
        return cnt



















