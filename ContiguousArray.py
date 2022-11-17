"""
    Problem Statement: Given a binary array nums, return the maximum length of a 
                       contiguous subarray with an equal number of 0 and 1.

    Time complexity: O(n)

    Space complexity: O(n)

    Accepted on LeetCode? Yes! 

    LeetCode Link: https://leetcode.com/problems/contiguous-array/
"""
from typing import List

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        res = 0
        arr = []
        hash_map = {0: -1}
        for idx, num in enumerate(nums):
            if idx == 0:
                arr.append(-1) if num == 0 else arr.append(1)
            else:
                arr.append(arr[idx-1] - 1) if num == 0 else arr.append(arr[idx-1] + 1)
                
        for idx, i in enumerate(arr):
            if i not in hash_map:
                hash_map[i] = idx
            else:
                res = max(idx - hash_map[i], res) 
        return res

if __name__ == "__main__":
    sol = Solution()
    nums = [1, 1, 1]
    ret = sol.findMaxLength(nums)
    print(ret)
    assert ret == 2