#Time Complexity: O(n)
#Space Complexity: O(n)
#Did this code successfully run on Leetcode: Yes

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        mapping = {0 : -1}
        rSum = 0
        maximum = 0

        for i in range(len(nums)):
            if nums[i] == 0: rSum -= 1
            else: rSum += 1

            if rSum in mapping:
                maximum = max(maximum, (i - mapping[rSum]))
            else:
                mapping[rSum] = i

        return maximum

        