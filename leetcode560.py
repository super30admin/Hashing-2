#Time Complexity: O(n)
#Space Complexity: O(n)
#Did this code successfully run on Leetcode: Yes

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        mapping = {0 : 1}
        runningSum = 0
        count = 0

        for num in nums:
            runningSum += num

            if runningSum - k in mapping:
                count += mapping.get(runningSum - k)

            mapping[runningSum] = mapping.get(runningSum, 0) + 1

        return count
        