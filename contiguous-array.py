# Time Complexity: O(n)
# Space complexity: O(n)

# The program successfully ran on Leetcode

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:        
        if nums == 0 and nums == None:
            return 0
        
        rsums = {}
        rsums[0] = -1
        rsum = 0
        l = 0
        
        for i in range(len(nums)):
            if nums[i] == 0:
                rsum -= 1 
            
            elif nums[i] == 1:
                rsum += 1
                
            if rsum in rsums:
                if i - rsums[rsum] > l:
                    l = i - rsums[rsum]
                    
            else:
                rsums[rsum] = i
        
        return l
