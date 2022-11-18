class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if len(nums)==0 or nums==None:
            return -1
        d={0:-1}
        max_1=0
        count=0
        #When we find zero we are decrementing count by 1
        #When we find One we are incrementing count by 1
        for i in range(len(nums)):
            if nums[i]==0:
                count=count-1
            else:
                count=count+1
            if count not in d:
                d[count]=i
            else:
                max_1=max(max_1,i-d[count])
        return max_1
#Time Complexity O(n)
#Space Complexity O(n)
            
