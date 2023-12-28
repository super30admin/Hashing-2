# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : Average : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Python dictionary.get method

class Solution:
    '''
    - Will use the concept of running sum (cumulative sum) to iterate only linearly
    - k = x - y | where  x is current iteration's running sum and y is running sum of some previous iteration
    - stored in hashmap. using x and k in current iteration will check if y exist in hashmap. accordingly will increase count
    '''
    def subarraySum(self, nums: List[int], k: int) -> int:
        running_sum = 0
        hashmap = {}
        hashmap[0] = 1   # for accomodating the first occurence of running sum equivalent to k
        count = 0 
        for num in nums:
            running_sum += num
            required = running_sum - k
            if required in hashmap:
                count = count + hashmap[required]
            hashmap[running_sum] = hashmap.get(running_sum, 0) + 1  # will create new value in hashmap if doesnt exist already
        return count