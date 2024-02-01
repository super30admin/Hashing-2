"""Time complexity: O(n)
Space complexity: O(n)"""

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        count=0
        sum=0
        sum_map = {0:1}
        for i in range(n):
            sum +=nums[i]
            if sum-k in sum_map:
                count+=sum_map[sum-k]
            sum_map[sum] = sum_map.get(sum, 0)+1
        return count