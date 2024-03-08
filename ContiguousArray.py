# TC = O(n)
# SC = O(n)
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        rsum = 0
        cmap = {}
        cmap[0] = -1
        length = 0
        for i in range(len(nums)):
            if nums[i] == 1:
                rsum += 1
            if nums[i] == 0:
                rsum += -1
            if rsum in cmap:
                length = max(length, i - cmap[rsum])
            else:
                cmap[rsum] = i

        return length
