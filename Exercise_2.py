#Time Complexity : O(N), N being the total number letters in string.
#Space Complexity : O(N), because dictionary can be the length of string.
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Was not able to find the approach in the
# beginning at all. Coding after reviewing the approach was still a little difficult. 

#Your code here along with comments explaining your approach in three sentences only
'''
Keep a running sum that adds 1 or -1. Create a dictionary with key as the running sum
and value as index of first occurance. Update result everytime a longer result is found. 
'''
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        rSum = -1
        dictionary = {}
        dictionary[rSum] = -1
        result = 0
        for i in range(len(nums)):
            num = nums[i]
            #add running sum with 1 if value is 1, else -1 if value is 0. 
            if num==0:
                rSum = rSum-1
            else:
                rSum = rSum+1
            #save first occurance of running sum in dictionary with value of i. 
            #update result if current i minus previous i is greater. 
            if rSum in dictionary.keys():
                sub = i - dictionary[rSum]
                if result<sub:
                    result = sub
            else:
                dictionary[rSum] = i
        return result
