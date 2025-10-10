class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        final = {0: 1}
        intial_count = 0

        count = 0

        for i in range(len(nums)):
            intial_count += nums[i]

            if intial_count - k in final:
                count += final[intial_count - k]

            if intial_count not in final:
                final[intial_count] = 1
            else:
                final[intial_count] += 1

        return count



