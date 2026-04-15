#  Time Complexity : O(n)
#  Space Complexity :  O(n)
#  Did this code successfully run on Leetcode :  Yes
#  Any problem you faced while coding this :  Took a while to understand that we are setting of map[0]=-1 to handle the case when we have a valid subarray starting at 0.

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        running_sum_map={0:-1}
        res=0
        track=0
        
        for i in range(len(nums)):
            if nums[i] == 1:
                track+=1
            else: 
                track-=1
        
            if track in running_sum_map:
                res = max(res,i-running_sum_map[track])
            else:
                running_sum_map[track] = i
        
        return res                                   
