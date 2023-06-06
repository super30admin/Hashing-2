# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to find the running sum and look for in hashmap if not found add to hashmap else find the maximum of index and hash
# map value and return.

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        d={}
        d[0]=-1
        rsum=0
        m=0
        for i in range(0,len(nums)):
            if(nums[i]==1):
                rsum=rsum+1
            elif(nums[i]==0):
                rsum=rsum-1
            if (rsum in d):
                m=max(m, i-d[rsum])    
            else:
                d[rsum]=i
        return m