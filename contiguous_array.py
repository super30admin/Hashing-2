# Time Complexity: O(n) where n is the number of elements in the list.
# Space Complexity: O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        d = dict()
        d[0] = -1
        rsum = 0
        l = 0
        for index,i in enumerate(nums):
            if i == 0:
                rsum -=1
            else:
                rsum += 1
            if rsum in d:
                l = max(l,index - d[rsum])
            else:
                d[rsum] = index
        return l