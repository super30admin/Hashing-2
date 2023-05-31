# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        con = 0
        pre = 0
        preToIndex = {0: -1}
        for i, num in enumerate(nums):
            pre += 1 if num else -1
            con = max(con, i - preToIndex.setdefault(pre, i))
        return con