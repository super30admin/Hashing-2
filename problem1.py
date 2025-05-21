"""
Approach: index i can form multple subarrays with j where 0 <= j < i since we have negative numbers present too. Can use a prefixSum 
counter hashmap which will say prefixSum[i] - k = prefixSum[j]? which will give the counts of the subarrays that i forms with j s.t. sum(i to j) = k
"""
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        
        prefixCount = collections.defaultdict(int)
        prefixCount[0] = 1 #base case that 0 - i could sum to k
        res = 0
        sums = 0
        for i in range(n):
            sums += nums[i]
            
            if sums - k in prefixCount:
                res += prefixCount[sums - k]
            prefixCount[sums] += 1
        return res