"""
Approach: 
We are using running sum approach and a hashmap to solve this problem
we are initilizing the running sum to 0. if there is a 1 we are adding 1 and -1 if it is zero.
we iterate through all the integers in the array and update the running sum accordingly.
if running sum is already in the hashmap, then we calculate the max running sum and update it.
else we add the running sum as key and its index to the hashmap
in the end we return maxvalue which gives the longest contiguous array length.

Time Complexity: O(n)

Space Complexity: O(n)

Passed in Leetcode: Yes

Any difficulties: No

"""

from typing import List
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        rSum = 0
        maxValue = 0
        rsum_index = {}
        rsum_index[0] = -1

        for i in range(len(nums)):
            if nums[i] == 1:
                rSum += 1
            else:
                rSum -= 1
            
            if rSum in rsum_index:
                maxValue = max(maxValue,i - rsum_index[rSum])
            else:
                rsum_index[rSum] = i
        return maxValue


sol = Solution()
nums = [0,1,1,1,1,1,0,0,0]
print(sol.findMaxLength(nums))

        