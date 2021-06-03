"""
https://leetcode.com/problems/contiguous-array/submissions/

Time Complexity: O(n)
Space Complexity: O(n) --> HashMap creation
I tried this on Leetcode.
It did not give any errors.
"""


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        sumVal = 0
        length = 0

        hashMap = {}
        hashMap[0] = -1

        for i in range(len(nums)):
            if nums[i] == 0:
                sumVal -= 1
            else:
                sumVal += 1

            if sumVal in hashMap:
                length = max(length, i - hashMap[sumVal])
            else:
                hashMap[sumVal] = i
        return length
