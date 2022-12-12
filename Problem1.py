T.C : O(n)
S.C : O(n)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if not nums:
            return 0
        hmap = {}
        hmap[0] = 1
        count = 0
        csum = 0
        for i in range(len(nums)):
            csum += nums[i]
            if csum - k in hmap:
                count += hmap[csum-k]
            if csum not in hmap:
                hmap[csum] = 0
            hmap[csum] += 1
        return count
