#Time Complexity : O(N), N being the length of array
#Space Complexity : O(N), because dictionary could have all values in array.
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : I think I switched an order in the coding
# that took forever to debug. 

#Your code here along with comments explaining your approach in three sentences only
'''Keep a running sum. At each instance of the running sum, save sum as key in dictionary
with value as the number of occurances. If running_sum - k is in dictionary keys, add value
to result. 
'''
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        rSum = 0
        dictionary = {}
        result = 0
        dictionary[rSum] = 1
        for i in range(len(nums)):
            #keeping running sum. 
            num = nums[i]
            rSum = rSum + num

            # add running_sum-k value to result if it exists. 
            if rSum-k in dictionary.keys():
                result = result+dictionary[rSum-k]
            # then, add running sum to dictionary or increment. 
            if rSum not in dictionary.keys():
                dictionary[rSum]=1
            else:
                dictionary[rSum]=dictionary[rSum]+1
                
        return result