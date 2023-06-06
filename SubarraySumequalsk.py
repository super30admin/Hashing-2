# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to find the running sum and subtract the target and look for in hash if not add to hashmap else increase the counter.

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        rsum=0
        d={}
        d[0]=1
        c=0
        for i in nums:
            rsum=rsum+i
            s=rsum-k
            if(s in d):
                c=c+d[s]
            if(rsum in d):
                d[rsum]=d[rsum]+1
            else:
                d[rsum] = 1
        return c