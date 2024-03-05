class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if len(nums)==0 or nums==None: return 0
        d={}
        d[0]=-1
        m=0
        count=0
        for i in range(len(nums)):
            if(nums[i]==0):
                count=count-1
            else:
                count=count+1
            if(count in d):
                m=max(m,i-d[count])
            else:
                d[count]=i
        return m