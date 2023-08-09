class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hmap = {0:1}
        count = 0
        complement = 0
        rsum = 0

        for i in range(0,len(nums)):
            rsum += nums[i]
            complement = rsum-k

            if complement in hmap:
                count += hmap[complement]
            
            if rsum not in hmap:
                hmap[rsum] = 1
            else:
                hmap[rsum] += 1

        return count