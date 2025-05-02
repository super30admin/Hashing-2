# Problem 2 : Contiguous Array
# Time Complexity : O(n) where n is the length of the nums list
# Space Complexity : O(n) where n is the length of the nums list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''
# Three line explanation of solution in plain english
'''
Will convert 0s to -1s to track the balance between 0s and 1s ing running sum. Will use hash map to store the first index at which
each rSum occurs, allowing detection of sub-arrays with equal 0s and 1s. If previously rSum is encountered again, then length of
the balanced sub-array is calculated and the maximum is stored in ans. 
'''

# Your code here along with comments explaining your approach
from typing import List
from collections import defaultdict

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        # get the length of the nums
        length = len(nums)
        # define rSum which will store running sum and ans which will store number of sub-arrays
        rSum = 0
        ans = 0
        # define hashMap which will store rSum as key and i(index) as value
        hashMap = defaultdict(int)
        # dummy to catch the sub array starting at index 0
        hashMap[0] = -1
        # loop from 0 to length
        for i in range(length):
            # check if ith element is 0 and if it is then decrement the rSum 
            if nums[i] == 0:
                rSum -= 1
            # else increment the rSum
            else:
                rSum += 1
            # check rSum is in hash map and if it is then get the maximum between ans and (i - values of hash map at rSum) and store in ans
            if rSum in hashMap:
                ans = max(ans, i - hashMap[rSum])
            else:
                # else set the value of hashMap for key rSum as i
                hashMap[rSum] = i
        # return ans
        return ans
