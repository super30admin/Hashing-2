#time - o(n)
#space -- o(n)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        rsum_index = {}
        rsum = 0
        count = 0
        for i in range(len(nums)):
            rsum = rsum + nums[i]
            if rsum == k:
                count += 1

            if rsum - k in rsum_index:
                count += rsum_index[rsum - k]

            if rsum in rsum_index:
                rsum_index[rsum] = rsum_index[rsum] + 1
            else:
                rsum_index[rsum] = 1

        return count