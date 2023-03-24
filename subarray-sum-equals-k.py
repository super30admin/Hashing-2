

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# 
"""
get the running sum of elements. iterate through each element and check if the rolling sum - k has appeared before. add all the appearances
if rolling sum is not present in hashmap, add an entry, and if already exists then add 1.
"""


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:

        track = {0:1}
        rSum = 0
        total = 0

        for i in range(len(nums)):
            rSum += nums[i]
            if rSum - k in track:
                total += track[rSum - k]
            if rSum in track:
                track[rSum] += 1
            else:
                track[rSum] = 1



        return total
