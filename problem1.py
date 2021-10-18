# Time Complexity: O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: ✔️
# Any problem you faced while coding this: Not sure if this is the most efficient solution

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count, sum = 0, 0
        hash_map = {}
        hash_map[0] = 1
        hash_sum = 0
        for num in nums:
            hash_sum += num
            if hash_sum - k in hash_map:
                count += hash_map[hash_sum - k]
            if hash_sum in hash_map:
                hash_map[hash_sum] = hash_map[hash_sum] + 1
            else:
                hash_map[hash_sum] = 1
        return count
