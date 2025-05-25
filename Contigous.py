# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def findMaxLength(self, nums):
        hmap = {0: -1}  # rSum : index
        maxL = 0
        rSum = 0
        for i in range(len(nums)):
            if nums[i]==0:
                rSum -= 1
            else:
                rSum += 1
            if rSum in hmap:
                maxL = max(maxL,i-hmap[rSum])
            else:
                hmap[rSum] = i
        return maxL