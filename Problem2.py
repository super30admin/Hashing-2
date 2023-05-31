# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We track the number of 1 and 0 using a running sum, whose sum is 0 if the array has 
# an equal no. of 0s and 1s. We also use a hashmap to store the index of the 
# first occurrence of each running sum. At any point, we can use this hashmap to
# determine the start index of the longest possible subarray having balanced 0s and 1s.

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        maxVal = 0
        m = {}
        rSum = 0
        m[0] = -1
        for i in range(len(nums)):
            rSum += (1 if nums[i] == 1 else -1)
            if rSum in m:
                sbArr = i - m[rSum]
                maxVal = max(maxVal, sbArr)
            else:
                m[rSum] = i
        return maxVal