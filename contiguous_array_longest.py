class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        dic1={}
        currsum=0
        dic1[0]=-1
        max1=0
        for i in range(0,len(nums)):
            if nums[i]==0:
                currsum=currsum-1
            else:
                currsum=currsum+1
            if currsum not in dic1:
                dic1[currsum]=i
            else:
                max1=max(max1,i-dic1[currsum])
        return max1



        