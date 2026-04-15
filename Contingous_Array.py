# Time Complexity : O(N) N:length of array.
# Space complexity :O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# start dictionary with {0: -1} to catch balanced subarrays.
# Every time we see a running sum we've seen before, it means there's a balanced subarray, so we calculate that distance and keep the longest one.

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        mapping = {0: -1}
        running_sum = 0
        result = 0

        for i in range(len(nums)):
            if nums[i] == 0:
                running_sum -= 1
            else:
                running_sum += 1
            
            if running_sum in mapping:
                count = i - mapping[running_sum]
                result = max(result,count)
            else:
                mapping[running_sum] = i
        return result