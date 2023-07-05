#Time complexity: O(n)
#Space complexity: O(n)

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        mapping = {0: 1}
        rsum = 0

        for i in range(len(nums)):
            rsum += nums[i]
            if rsum - k in mapping:
                count += mapping[rsum - k]
            
            if rsum in mapping:
                mapping[rsum] += 1
            else:
                mapping[rsum] = 1

        return count
