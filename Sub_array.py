class Solution:
    def subarraySum(self, nums: list[int], K: int) -> int:
        res = 0
        curSum = 0
        prefixSums = {0: 1}

        for n in nums:
            curSum += n
            diff = curSum - K

            res += prefixSums.get(diff, 0)
            prefixSums[curSum] = 1 + prefixSums.get(curSum, 0)

        return res
