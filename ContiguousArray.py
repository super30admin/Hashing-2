from typing import List

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        res = 0
        count = 0
        d = {0:-1}
        for idx, n in enumerate(nums):
            if n == 1:
                count += 1
            else:
                count -= 1
            if count not in d:
                d[count] = idx
            else:
                res = max(res, idx - d[count])

        return res