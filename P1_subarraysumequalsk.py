"""
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)


I realized that if I keep track of all the previous prefix sums
I can quickly check how many subarrays ended here and sum to k.

"""

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        count = 0
        curr_sum = 0
        prefix_sums = {0: 1}

        for num in nums:
            curr_sum += num
            if curr_sum - k in prefix_sums:
                count += prefix_sums[curr_sum - k]
            prefix_sums[curr_sum] = prefix_sums.get(curr_sum, 0) + 1

        return count
