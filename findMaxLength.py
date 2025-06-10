# // Time Complexity :  O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no







class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        #use running sum if running sum already occured before which means from that point to current point number of 0's and 1's are equal 
        presum=dict()
        presum[0]=-1
        rsum=0
        ans=0
        for i in range(len(nums)):
            if nums[i]==0:
                rsum-=1     
            else:
                rsum+=1
            if rsum in presum:
                ans=max(ans,i-presum[rsum])
            else:
                presum[rsum]=i
        return ans

                
        
