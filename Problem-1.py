# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# Maintain a running prefix sum and store how many times each prefix appears.
# For each position, if (prefix − k) exists, then subarrays ending at this index sum to k.
# Accumulate counts and update the prefix frequency map.

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefix_sums = {0:1}
        prefix = 0
        res = 0
        for i in nums:
            prefix += i
            if prefix-k in prefix_sums:
                res += prefix_sums[prefix-k]
            prefix_sums[prefix] = prefix_sums.get(prefix, 0) + 1
        return res