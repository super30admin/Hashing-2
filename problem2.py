
## Problem2 (https://leetcode.com/problems/contiguous-array/)
"""
Create a dictionary and store running sum, except since its binary, use -1 for when you encounter a 0 and 1 if you encounter a 1
if the rsum is encounter again in the seen set, calculate the past occurence of the index and its your max lenght
storing dictionary take  O(n) space since rsum can range upto rnage of integers, and tc for the same is O(n) as well since we traverse the whole nums
"""
class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        runningSum = 0
        count = 0
        seen = {0: -1} #create a seen dictionary so that we map the running sum values to the index, map a dummy value of -1 to 0 for hadling the edge case

        for i in range(len(nums)):
            if nums[i] == 0: #if the num is 0, decrement the rsum
                runningSum -= 1
            else:
                runningSum += 1 #if the num is 1, increment the rsum

            if runningSum in seen: #if the rsum is already there in the seen, 
                count = max(count, i - seen[runningSum]) #calculate the max count for it with comparing it with the previous occurence of the same
            else:
                seen[runningSum] = i #else add it to seen

        return count
