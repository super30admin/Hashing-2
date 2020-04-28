"""
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Failed for some test case
// Any problem you faced while coding this :
"""

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        d = {}
        cnt=0
        for i in range(len(nums)):
            y = k-nums[i]
            if y in d:
                cnt += 1
            else:
                d[y] = True
        return cnt
