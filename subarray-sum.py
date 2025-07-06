"""
https://leetcode.com/problems/subarray-sum-equals-k/description/

Brute force: nested for loops --> O(n2)
Optimal: If we know the sum of all elements before i, and the sum of all elements before j,
then the sum of the subarray [i...j] is just prefix[j] - prefix[i - 1].

prefixSum[j] - prefixSum[i] == k ⟺ subarray (i, j] sums to k.
Rearrange: prefixSum[j] - k == prefixSum[i]. That means: If we’re at index j with sum prefixSum[j].We just need to know how many times we’ve seen prefixSum[j] - k before.

Edge cases:
empty array
1 element array

Time Complexity: O(n)
Space Complexity: O(n)
"""
from collections import defaultdict

class Solution:
    def subarraySum(self, nums, k):
      prefix = 0
      count = 0
      seen = defaultdict(int)
      seen[0] = 1
      
      for num in nums:
        prefix = prefix + num
        count = seen[prefix-k] + count
        seen[prefix] += 1
      return count
    
nums = [1,1,1]
k = 2
sol = Solution()
print(sol.subarraySum(nums, k))