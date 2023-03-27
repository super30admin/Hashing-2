# T.c-> O(n)
# S.c-> O(1)
class Solution:
    def findMaxLength(self, nums) :
        
        hashMap= {}
        Max=0
        rSum=0
        hashMap[0]=-1

        for i in range(len(nums)):
            if  nums[i]==0:
                rSum= rSum-1
            else:
                rSum+=1
            # Check for the running sum.
            if rSum not in hashMap.keys():
                hashMap[rSum]= i
            else:
                # Update the maximum.
                Max= max(Max, i-hashMap[rSum])
        return Max
