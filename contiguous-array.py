# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        dict = {}
        dict[0] = -1
        rsum = 0
        max_len = 0

        for i in range(len(nums)):
            if nums[i] == 0:
                rsum -= 1
            else:
                rsum += 1

            if rsum in dict:
                max_len = max(max_len, i- dict[rsum])
            else:
                dict[rsum] = i
                
        return max_len
    
sc = Solution()
nums = [0,1]
print(sc.findMaxLength(nums))

        