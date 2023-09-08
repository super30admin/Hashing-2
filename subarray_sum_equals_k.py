# Time Complexity: O(n) where n is the number of numbers in the list.
# Space Complexity: O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        rSum = 0
        d = dict()
        d[rSum] = 1 # Running sum of 0 has occured once
        res = 0
        for i,val in enumerate(nums):
            rSum = rSum + val
            diff = rSum - k
            if diff in d:
                res = res + d[diff]
            if rSum in d:
                d[rSum] += 1
            else:
                d[rSum] = 1
        return res
