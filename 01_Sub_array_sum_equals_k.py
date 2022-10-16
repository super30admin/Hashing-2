# // Time Complexity : O(n) because only once we iterate
# // Space Complexity : O(n) because hashMap can be created of size n, having n different prefixSums
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        hashMap = collections.defaultdict(int)
        
        hashMap[0] = 1
        
        prefixSum = 0
        ctr = 0
        
        for num in nums:
            prefixSum += num
            excess = prefixSum - k
            if hashMap[excess]:
                ctr += hashMap[excess]
            hashMap[prefixSum] += 1
            
        return ctr