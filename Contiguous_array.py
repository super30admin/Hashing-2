from collections import defaultdict


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        staging = {0: -1}
        max_count = 0
        intial_count = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                intial_count -= 1
            else:
                intial_count += 1
            if intial_count not in staging:
                staging[intial_count] = i
            else:
                max_count = max(max_count, i - staging[intial_count])

        return max_count



