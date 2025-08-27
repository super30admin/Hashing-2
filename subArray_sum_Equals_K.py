'''
sum_(i,j) = sum_(0,j) - sum_(0,i) where, sum_(i,j) = sum of elements from index i to j-1

so if I keep storing sum(0,i) in map, and then at j idx, search for sum(0,i*) such that 
target = sum(0,j)-sum(0,i), i.e. in dict search if sum(0,j) - target is present or not. 
If TRUE, that gives us the sub-array sum equals k
Time Complexity: O(N) - Linear search
Space Complexity: O(N) - HashMap to store the sum(0,i) 
'''
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        rs = 0
        rs_map = {}
        rs_map[0] = 1 # initial rs=0 ->IMPORTANT (when we have elements = target)
        ans = 0
        for i in range(len(nums)):
            rs+=nums[i]
            if rs-k in rs_map: # Search for sum(0,j)-target, so that sum(0,j)-sum(0,i)=target 
                ans+=rs_map[rs-k] # All such possibilities
        
            if rs not in rs_map: # if current rs val is not present
                rs_map[rs]=0
            rs_map[rs]+=1 
        return ans