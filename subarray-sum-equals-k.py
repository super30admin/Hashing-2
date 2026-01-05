''' Time Complexity : O(n)
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : Calculate the Running Sum at each index.
              IF diff of Running Sum and k is already in hashmap, that means we have got subarray at that running sum
'''
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        result = 0
        rSum = 0 
        hashmap = {}
        hashmap[0] = 1
        for i in range(len(nums)):
            rSum += nums[i]
            diff = rSum - k
            if diff in hashmap:
                result += hashmap[diff]
            hashmap[rSum] = hashmap.get(rSum,0) + 1
        return result