#Time Complexity: O(n)
#Space Complexity: O(n)
from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        rsum = 0
        hashmap = {}
        hashmap[0] = 1
        for i in range(len(nums)):
            rsum += nums[i]
            if rsum - k in hashmap:
                count += hashmap[rsum - k]
            hashmap[rsum] = hashmap.get(rsum, 0) + 1
        return count
