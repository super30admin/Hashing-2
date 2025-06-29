# // Time Complexity : O(n) 
# // Space Complexity : O(n)

def findMaxLength(self, nums: List[int]) -> int:
    sumTotal = -1 
    maxLen = 0
    if(len(nums) == 1):
        return 0

    hashM = {-1:-1}

    for i in range(len(nums)):  
        if(nums[i]==0):
            sumTotal -= 1 
        else:
            sumTotal += 1    
        
        if(sumTotal in hashM):
            maxLen = max(maxLen , i-hashM[sumTotal])
        else:
            hashM[sumTotal] = i
    return maxLen