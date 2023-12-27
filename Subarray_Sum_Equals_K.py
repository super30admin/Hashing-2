#Time Complexity: O(n)
#Space complexity: O(n)

from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if nums is None or len(nums) == 0:
            return 0

        hashmap = {}
        counter = 0
        rSum = 0
        hashmap[0] = 1  # Initialize with the sum 0 seen once

        for i in range(len(nums)):
            rSum += nums[i]

            # Check if (rSum - k) exists in the hashmap
            if rSum - k in hashmap:
                counter += hashmap[rSum - k]

            # Update the hashmap with the current rSum
            if rSum in hashmap:
                hashmap[rSum] += 1
            else:
                hashmap[rSum] = 1

        return counter
