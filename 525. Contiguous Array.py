#Time Complexity:O(n)
#Space Complexity:O(n)
class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        rSum=0
        hashlength={}
        hashlength[0]=-1
        maxi=0
        for i in range(len(nums)):
            if nums[i]==0:
                rSum=rSum-1
            else:
                rSum=rSum+1
            if rSum not in hashlength:
                hashlength[rSum]=i
            else:
                maxi=max(maxi,i-hashlength.get(rSum))
        return maxi
        
        
