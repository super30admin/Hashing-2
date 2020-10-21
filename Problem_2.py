
"""
Time Complexity : O(n)- as we are iterating through the string, all other operations are O(1)
Space Complexity : O(n)- as there can be so many 1's
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
For this solution, I will use a dictionary. For each 0 I encounter, I will decrease the sum by 1
and for every 1 I encounter, I will increase the sum by 1. This means that, whenever a particular sum already
exists in the dictionary, then in that range, we have equal number of 0's and 1's. This is because, 
x-x=0. and 0 will come for equal 0 and 1 in the subarray. In the dictionary, we maintain the first
index when we encountered  a particular sum and compare with it every time that sum reappears. 
"""


class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        count = 0
        d = {0: -1}
        summ = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                summ -= 1
            else:
                summ += 1
            if summ in d:
                count = max(count, i-d[summ])
            else:
                d[summ] = i
        return count
