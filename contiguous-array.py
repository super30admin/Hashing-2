''' 
Time Complexity : O(n)
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No

Approach : Calculate the Running Sum at each index.
'''

class Solution:
    def findMaxLength(self, nums):
        rSum = 0
        hashmap = {}
        hashmap[0] = -1
        result = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                rSum -= 1
            else:
                rSum += 1

            if rSum in hashmap:
                length = i - hashmap[rSum]
                result = max(result, length)
            else:
                hashmap[rSum] = i
        return result