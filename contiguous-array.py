"""
https://leetcode.com/problems/contiguous-array/description/

Brute force: Check every subarray, count the number of 0s and 1s, and return the length if equal. --> O(n2)
Optimal: If you turn: 0 into -1, 1 stays 1. Then the problem becomes: Find the longest subarray whose sum is 0. Now it's a prefix sum with target = 0. If the sum from i to j is 0, that means: # of 1s == # of 0s  (because 0 became -1, and 1 stayed 1) Now we apply the same prefix sum + hashmap trick: If prefix[i] == prefix[j], then the subarray between i+1 and j has sum 0. We track the first time each prefix sum is seen. When we see that sum again later, the subarray from first_index + 1 to current_index is zero-sum.

Edge case:
no solution subarray
1 element array

Time Complexity: O(n)
Space Complexity: O(n)
"""
from collections import defaultdict

class Solution:
    def findMaxLength(self, nums):
      prefix = 0
      seen = defaultdict(int)
      seen[0] = -1
      max_length = 0
      
      for i, num in enumerate(nums):
        if num == 0: #transformation
          prefix += -1
        if num == 1:
          prefix += 1
          
        if prefix in seen: # We're counting: Every past prefix that matches current Because each match implies a subarray between those two points with sum = 0
          max_length = max(max_length, i - seen[prefix])
        else:
          seen[prefix] = i
      return max_length
    
nums = [0,1]
sol = Solution()
print(sol.findMaxLength(nums))
          