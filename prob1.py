# https://leetcode.com/problems/subarray-sum-equals-k/
# Using running sum and hashmap to count subarrays with sum equal to k

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # Storing 0 and 1 by default to handle edge cases like when the subarray starts from index 0
        freq = {0:1}
        count = 0
        prevSum = 0
        for i in nums:
            prevSum+=i
            curSum = prevSum-k
            if curSum in freq:
                count += freq[curSum]
            freq[prevSum] = freq.get(prevSum,0)+1
        return count



        