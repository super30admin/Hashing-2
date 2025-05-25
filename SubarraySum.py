# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def subarraySum(self, nums, k) -> int:
        hmap = {0:1}
        count = 0
        rSum = 0
        for i in range(len(nums)):
            rSum += nums[i]
            # Running Sum - Target
            if rSum - k in hmap:
                count += hmap[rSum-k]
            # Running Sum not in hash map
            if rSum not in hmap:
                hmap[rSum] = 0
            hmap[rSum] = hmap[rSum]+1
        return count