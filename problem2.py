class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        # to handle the case we get the running total as 0 from the starting
        freq_map={0:-1}
        res=0
        total=0
        for i in range(len(nums)):
            #Do +1 for 0 and Do -1 for 1
            if nums[i]==0:
                total+=1
            else:
                total-=1
            if total not in freq_map:
                freq_map[total]=i
            else:
                #whenever we see the running total repeating
                #which implies we got the balanced array in between
                res=max(res,i-freq_map[total])
        return res
            
        
        