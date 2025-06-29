#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        rSum = 0
        res = 0
        map = {0: 1}

        for i in nums:
            rSum += i
            cmp = rSum - k
            if cmp in map:
                res += map[cmp]
            map[rSum] = map.get(rSum, 0) + 1

        return res



