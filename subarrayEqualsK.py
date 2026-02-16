# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use prefix sum + hashmap. At each index, compute cumulative sum.
# Store frequency of each prefix sum to handle multiple matches.

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        h_map = {0: 1}
        c_sum = 0
        res = 0

        for i in nums:
            c_sum += i
            if (c_sum - k) in h_map:
                res += h_map[c_sum - k]

            if c_sum not in h_map:
                h_map[c_sum] = 1
            else:
                h_map[c_sum] += 1

        return res
