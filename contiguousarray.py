class Solution:
    def findMaxLength(self,nums):
        count=0
        max_length=0
        hashmap={0:-1}

        for i in range(len(nums)):
            count +=-1 if nums[i]==0 else 1
                
            if count in hashmap:
                max_length=max(max_length,i-hashmap[count])
            else:
                hashmap[count]=i
        return max_length
    
sol=Solution()
print(sol.findMaxLength([0,1]))
print(sol.findMaxLength([0,1,0]))
print(sol.findMaxLength([0,1,1,1,1,1,0,0,0,]))
print(sol.findMaxLength([1,1,1,1]))