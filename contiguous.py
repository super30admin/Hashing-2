# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Convert 0 to -1 and 1 to +1 and compute prefix sum.
# Store first occurrence of each prefix sum in hashmap to maximize length.

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        max_len = 0
        h_map = {}
        c_sum = 0

        for i in range(len(nums)):
            if nums[i] == 0:
                c_sum -= 1
            else:
                c_sum += 1

            if c_sum == 0:
                max_len = i + 1
            elif c_sum in h_map:
                max_len = max(max_len, i - h_map[c_sum])
            else:
                h_map[c_sum] = i

        return max_len
