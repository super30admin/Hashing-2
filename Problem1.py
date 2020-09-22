# Time Complexity: O(N^3)
# Space Complexity: O(1)
# Leetcode all test cases passed: No, 58/81 passed, TLE
# Any difficulties: Yes, couldn't find an optimal solution. Tried sliding window but couldn't do it.

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        for i in range(len(nums)):
            for j in range(i, len(nums)):
                if sum(nums[i:j+1]) == k:
                    count += 1
        return count
