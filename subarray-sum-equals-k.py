# Time Complexity: O(n)
# Space complexity: O(n)

# The program successfully ran on Leetcode

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:      
        if len(nums) == 0 or nums == None:
            return 0
        
        rsums = {}
        rsums[0] = 1
        rsum = 0
        count = 0
        
        for i in nums:
            rsum += i
            diff = rsum - k
            
            if diff in rsums:
                count += rsums[diff]
                
            if rsum in rsums:
                rsums[rsum] += 1
            else:
                rsums[rsum] = 1
                
        return count
                
        