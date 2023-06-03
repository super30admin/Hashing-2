from typing import List
class Solution:
	    def subarraySum(self, nums: List[int], k: int) -> int:
                count = 0
                j = 0
                for i in range(len(nums)):
                    if sum(nums[j:i + 1]) == k or nums[i] == k:
                        count += 1
                    elif sum(nums[:i + 1]) > k:
                        j += 1
                        if sum(nums[j:i + 1]) == k:
                            count += 1
                return count