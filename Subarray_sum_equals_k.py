class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        dic1={}
        dic1[0]=1
        count=0
        currsum=0
        for i in range(0,len(nums)):
            currsum=currsum+nums[i]
            if (currsum-k) in dic1:
                count+=dic1[currsum-k]
            
            if currsum not in dic1:
                dic1[currsum]=1
            else:
                dic1[currsum]+=1

        return count


        