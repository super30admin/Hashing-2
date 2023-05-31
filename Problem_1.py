# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        sub = 0
        pre = 0
        count = collections.Counter({0: 1})
        for num in nums:
            pre += num
            sub += count[pre - k]
            count[pre] += 1
        return sub