class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hmap = {0:-1}
        rsum = 0
        maxl = 0

        for i in range(0,len(nums)):
            if nums[i] == 0:
                rsum -= 1
            else:
                rsum += 1
            if rsum in hmap:
                maxl = max(maxl,i-hmap[rsum])
            else:
                hmap[rsum] = i
        return maxl