"""
https://leetcode.com/problems/subarray-sum-equals-k/submissions/

Time Complexity: O(n)
Space Complexity: O(n)
This worked on leetcode.
It did not give any errors.
"""


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        rSum = 0

        hashMap = {}
        hashMap[0] = 1
        for i in range(len(nums)):
            rSum += nums[i]

            if (rSum - k) in hashMap:
                count += hashMap[rSum - k]

            if rSum not in hashMap:
                hashMap[rSum] = 0
                hashMap[rSum] = 0
            hashMap[rSum] += 1
        return count
