# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : Average : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    '''
    - Will use the concept of running sum (cumulative sum) to iterate only linearly
    - x - y = 0 | where  x is current iteration's running sum and y is running sum of some previous iteration
    - stored in hashmap with value as index. If running sum found at any previous index, then difference will be compared to max.
    '''
    def findMaxLength(self, nums: List[int]) -> int:
        hashmap = {}
        maximum = 0
        hashmap[0] = -1     # to accomodate for initial occurence
        running_sum = 0
        for index in range(len(nums)):
            if nums[index] == 0:
                running_sum -= 1
            else:
                running_sum += 1
            if running_sum in hashmap:
                length = index - hashmap[running_sum]
                if length > maximum:
                    maximum = length
            else:
                hashmap[running_sum] = index
        return maximum