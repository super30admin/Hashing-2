# Time Complexity : O(N) N:length of array.
# Space complexity :O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Use a dictionary to keep track of how many times each running sum has occurred so far.
# calculate diff = running_sum - k; if that diff exists it means we just completed one or more subarrays that sum to k.
# increment the count for the current running_sum in the dictionary if exist if not add new value.

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        mapping = {0:1}
        count = 0 
        running_sum = 0
        diff = 0

        for i in range(len(nums)):
            running_sum += nums[i]
            diff = running_sum - k

            if diff in mapping:
                count += mapping[diff]

            if running_sum in mapping:
                mapping[running_sum] += 1
            else:
                mapping[running_sum] = 1
        return count
