"""
Time Complexity : O(n)- as we are iterating through the string, all other operations are O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
For this solution, I will use a dictionary. It is almost the same as contigous array question. Here at every point
we are calculating the running sum and check if it is present in the dictionary or not.
If it is present, just increase its count, otherwise set it to one.Also, we will check (runnig sum-k)
is in the dictionary or not. If it is already present, that means, sum k has occured again, so will increment
count with value of d[summ-k]
"""


class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if not nums:
            return 0
        d = {0: 1}
        count = 0
        summ = 0
        for i in range(len(nums)):
            summ += nums[i]
            if (summ-k) in d:
                count += d[summ-k]
            if summ in d:
                d[summ] += 1
            else:
                d[summ] = 1
        return count
