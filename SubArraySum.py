# TC= O(n)
# SC =O(n)


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        rsum = 0
        cmap = {}
        cmap[0] = 1
        count = 0

        for i in range(len(nums)):
            rsum += nums[i]
            if rsum - k in cmap:
                count += cmap[rsum - k]
            if rsum not in cmap:
                cmap[rsum] = 1
            else:
                cmap[rsum] += 1

        return count
