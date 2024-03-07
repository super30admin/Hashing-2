# T.C: O(n)
# S.C: O(n)

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hmap = {}
        hmap[0] = 1
        count = 0
        rSum = 0
        for i in range(len(nums)):
            rSum += nums[i]
            y = rSum - k
            if y in hmap:
                count += hmap.get(y)
            if rSum not in hmap:
                hmap[rSum] = 1
            else:
                hmap[rSum] = hmap.get(rSum) + 1

        return count
