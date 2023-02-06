# Author : Naveen US 
# Title : Subarry Sum Equals k

# Time Complexity : O(n)
# Space Complexity : O(n)
# id this code successfully run on Leetcode : Yes
# ny problem you faced while coding this : No



def subarraySum(self, nums: List[int], k: int) -> int:
    hashmap = {0:1} 
    result = 0
    rsum =0
    for i in range(len(nums)):
        rsum = rsum + nums[i]
        diff = rsum - k 
        if diff in hashmap: )
            result = result + hashmap[diff] 

        if rsum in hashmap:
            hashmap[rsum] = hashmap[rsum] + 1  
        else:
            hashmap[rsum] = 1 
    return result
