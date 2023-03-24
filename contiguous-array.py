
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# 
"""
Iterate through all element and keep track of running sum. create hasmap to store sum as key and index as value to calculate longest array.
if the sum is present in hashmap, check at which index it has appeared at first.
check if length of first index to current sum is larger than the max length
"""


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        tracking = {0 : -1}
        sum = 0
        max_len = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                sum -= 1
            else:
                sum += 1

            if sum in tracking:
                if i-tracking[sum] > max_len:
                    max_len = i-tracking[sum]

            else:
                tracking[sum] = i

        return max_len
