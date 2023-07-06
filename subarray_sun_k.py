# // Time Complexity :  O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count=0
        hash={0:1}

        running_sum=0
        l=len(nums)
        for i in range(l):
            running_sum+=nums[i]
            complement=running_sum-k
            if(hash.get(complement, 0)!=0):
                count+= hash.get(complement,0)
            hash[running_sum]=hash.get(running_sum,0)+1
        return count
        