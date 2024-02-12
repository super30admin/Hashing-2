class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        count = 0
        rsum = 0
        hmap = {0: 1}
        for i in range(n):
            rsum = rsum + nums[i]
            if (rsum - k) in hmap:
                count = count + hmap[rsum - k]
            hmap[rsum] = hmap.get(rsum) + 1 if rsum in hmap else 1
            # if (rsum) in hmap:
            #     hmap[rsum] = hmap.get(rsum) + 1
            # else:
            #     hmap[rsum] = 1
        return count
