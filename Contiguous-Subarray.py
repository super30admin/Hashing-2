# Time Complexity : O(n)
# Space Complexity : O(n)

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hmap = {0: -1}
        rSum = 0
        maxN = 0
        for i, num in enumerate(nums):
            if num == 0:
                rSum -= 1
            else:
                rSum += 1
            if rSum in hmap:
                maxN = max(maxN, i - hmap[rSum])
            else:
                hmap[rSum] = i
        return maxN