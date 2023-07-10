class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        dict={}
        subarr, count= 0,0
        for i in range(len(nums)):
            if nums[i]==1:
                count+=1
            else:
                count+= -1
            if count==0:
                subarr= i+1
            if count in dict:
                subarr= max(subarr, i-dict[count])
            else:
                dict[count]= i
        return subarr
        