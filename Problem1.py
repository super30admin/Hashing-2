"""
TC: O(N) {we iterate through the list twice, one for prefix sum and other for calculating the res}
SC: O(N) {we store the prefix sum in an array which is of size N}

Approach:
We initialize a prefix sum array.
Then we iterate through the length of the array and if the prefix sum at that point is equal to k, we update the res by 1. Again
if there exists a position in prefix array, where the sum at that point is equal to sum at i - k, we update that to res.
We also update the dictionary at every point for that prefix sum.

The problem successfully ran on Leetcode.
"""

from typing import List
from collections import defaultdict

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res = 0
        pre = []
        curr = 0
        for n in nums:
            curr += n
            pre.append(curr)
            
        d1 = defaultdict(int)

        for i in range(len(nums)):
            if pre[i] == k:
                res += 1
            
            if d1[pre[i] - k]:
                res += d1[pre[i] - k]

            
            d1[pre[i]] += 1

        return res