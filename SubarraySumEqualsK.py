"""
    Problem Statement: Given an array of integers nums and an integer k, 
                       return the total number of subarrays whose sum equals to k.

    Approach: Calculate the running sum, store in the hash table. If running sum is
              seen again increment count by the running sum value and increment
              running sum.

    Time complexity: O(n)

    Space complexity: O(n)

    Accepted on LeetCode? Yes! 

    LeetCode Link: https://leetcode.com/problems/subarray-sum-equals-k/
"""
from collections import defaultdict
from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hash_table = defaultdict(int)
        rSum: int = 0
        result: int = 0

        hash_table[0] = 1
        for num in nums:
            rSum += num
            if rSum - k in hash_table:
                result += hash_table[rSum - k]
            hash_table[rSum] += 1
        return result

if __name__ == "__main__":
    sol = Solution()
    nums, k = [1, 2, 3], 3
    ret = sol.subarraySum(nums, k)

    assert ret == 2