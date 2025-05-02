# Problem 1 : Subarray Sum Equals K
# Time Complexity : O(n) where n is the length of the nums list
# Space Complexity : O(n) where n is the length of the nums list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''
# Three line explanation of solution in plain english
'''
Loop through the array while maintaining running sum and using hash map to store frequency of each running sum. For each element, 
check if (rSum - k) exists in hash map, if it does, add its frequency to the result(valid sub array with sum k). Update hash map
with the current rSum and finally return total count of valid sub-arrays.
'''

# Your code here along with comments explaining your approach
from typing import List
from collections import defaultdict

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # get the length of the nums list
        length = len(nums)
        # define hashMap for storing the sum as key and frequency as value
        hashMap = defaultdict(int)
        # add dummy entry for sum 0 and frequency 1 in the hash map
        hashMap[0] = 1
        # define varibale rSum which will store current running sum and result which will store the total number of sub-arrays
        rSum = 0
        result = 0
        # loop from 0 to length
        for i in range(length):
            # add the value of ith position of nums array to rSum
            rSum += nums[i]
            # check (rSum - k) is in hash map. If it is then add the result value with the value at (rSum - k) of hash map and store in the result
            if (rSum - k) in hashMap:
                result += hashMap[rSum - k]
            # check if rSum not in hash map and if it is then create an entry in hash map with key rSum and value as 1
            if rSum not in hashMap:
                hashMap[rSum] = 1
            else:
                # else the add the 1 to the value of hash map at rSum
                hashMap[rSum] = hashMap.get(rSum, 0) + 1
        # return result
        return result
        