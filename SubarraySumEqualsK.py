class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        csum = count = 0
        hmap = {}
        hmap[0] = 1
        for i in range(len(nums)):
            csum += nums[i]
            if (csum - k) in hmap:
                prev_count = hmap.get(csum - k)
                count += prev_count
            
            if csum in hmap:
                num = hmap.get(csum)
                hmap[csum] = num + 1
            else:
                hmap[csum] = 1
        return count
