# Time Complexity: O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: ✔️
# Any problem you faced while coding this: Not sure if this is the most efficient solution

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hash_map = {}
        hash_map[0] = -1
        max_len, count = 0, 0
        for i in range(0, len(nums)):
            count = count + (1 if nums[i] == 1 else -1)
            if count in hash_map:
                max_len = max(max_len, i - hash_map[count] )
            else:
                hash_map[count] = i
        return max_len