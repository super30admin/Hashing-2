# Time Complexity : o(n)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        di = {}
        rsum = 0
        Max = 0
        di[0] = -1

        for i in range(len(nums)):
            if nums[i] == 0:
                rsum -= 1
            else:
                rsum += 1
            if rsum not in di:
                di[rsum] = i
            else:
                Max = max(Max, i - di[rsum])

        return Max