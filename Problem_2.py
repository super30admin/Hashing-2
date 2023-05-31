"""
Problem : 6

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""
class Solution(object):
    def findMaxLength(self, nums):
        res={0:-1}
        count=0
        maxlen=0

        for i in range(len(nums)):
            if nums[i]==1:
                count+=1
            else:
                count-=1
            if count in res:
                maxlen=max(maxlen,i-res[count])
            else:
                res[count]=i
        return maxlen


            