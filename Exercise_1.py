# Problem #17: Subarray Sum Equals K
#560 https://leetcode.com/problems/subarray-sum-equals-k/description/

# Author : Akaash Trivedi
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #560
# Any problem you faced while coding this : No

# Approach:
# we take the running sum (Prefix sum) from 0th index
# assuming your running sum is x and your target(k) and check if y is already in hashmap y = x - k
# that gives us the subarray with sum = k from hash[rsum-k] to hash[rsum]

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hashm = {0:1}
        count = 0
        rSum = 0
        for n in nums:
            rSum += n
            if (rSum - k) in hashm:
                count += (hashm[(rSum-k)])
            if rSum in hashm:
                hashm[rSum] += 1
            else:
                hashm[rSum] = 1
            
        return count