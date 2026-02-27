# https://leetcode.com/problems/subarray-sum-equals-k/

# Time Complexity: O(n)
# Space Complexity: O(n)

# For this subarray sum, we can implement a running sum solution. A hashmap is used to store rsum as key and the value 
# as the frequency or count of that running sum (this is what gives us the actual count of possible subarrays). We check
# if the rsum - k exists in our hashmap, if it does then there is avalid subarray that is equal to k. 
# We also check if running sum exists in hashmap, if so increment the value by 1, else insert the running sum with value as 1

# Examples to try [3,4,7,2,-3,1,4,2,0,1,6], k = 7

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:

        rsum = 0
        hm = {}
        count = 0

        hm[0] = 1
        for i in nums:
            rsum = rsum + i
            
            if (rsum - k) in hm:
                count += hm[rsum - k]
                
            if rsum in hm:
                hm[rsum] += 1    
            else:          
                hm[rsum] = 1
        