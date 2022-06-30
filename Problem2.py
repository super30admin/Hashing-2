'''
## Problem2 (https://leetcode.com/problems/contiguous-array/)
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.


'''
'''
Time Complexity : O(N)
Space Complexity : O(N)
'''

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        '''
        create a running sum and add running sum and index into hm
        if running already present in hm
        check if running ever occured if yes check that index - first occurence in hm is greater than max value
        if not move onto next
        '''
        rsum = 0
        result = 0
        if(len(nums)==0):
            return 0
        else :
            hm = {}
            hm[0] = -1
            for i in range(len(nums)):
                if(nums[i]==0):
                    rsum -= 1
                elif(nums[i]==1):
                    rsum += 1
                if rsum in hm:
                    
                    temp  = i - hm[rsum]
                    if(temp > result):
                        result = temp
                else :
                    hm[rsum] = i
        return result
                    
            