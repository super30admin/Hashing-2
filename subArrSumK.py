#Time Complexity :  O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res = 0
        curSum = 0
        d = {0:1}
        
        for num in nums:
            curSum = curSum + num
            
            #if difference is already in dict keys then update res
            #this if condition is checking for continuous sum
            if curSum-k in d.keys():
                res = res + d[curSum-k]
            
            #if currSum not in the dict keys then add curSum as key
            #and set the value to be 1
            if curSum not in d.keys():
                d[curSum] = 1
            #if the key is already. present in dict then increment by 1
            else:
                d[curSum] = d[curSum] + 1
        
        return res