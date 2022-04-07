class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if len(nums)==0 or nums==None:return 0
        d={}
        sum1=0
        total=0
        d[0]=1
        for i in range(len(nums)):
            sum1=sum1+nums[i]
            if(sum1-k in d):
                total=total+d[sum1-k]
            if(sum1 in d):
                d[sum1]=d[sum1]+1
            else:
                d[sum1]=1
            print(d)
        return total
                
        