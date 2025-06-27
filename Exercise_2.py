# Time Complexity: O(n)
# Space Complexity: O(1)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        
        if len(nums)==1 or len(nums)==0:
            return 0

        # Special case when entire array has equal number of 1s and 0s
        # sum(nums) returns number of 1s and len(nums)-sum(nums) gives number of 1s
        # if the below condition is true then the len of entire array consists of contiguos array of 0s and 1s
        if len(nums) / 2 == sum(nums):
            return len(nums)
        
        max_len = 0
        curr_sum=0

        # store the first element by default which represents the running sum before the 0th element
        val_idx = {0:-1}
        

        # calculate running sum and check if running sum and prev max len of subarray is greater
        for i in range(len(nums)):
            # increment curr_sum for every 1 and decrement for every 0
            if nums[i]==1:
                curr_sum+=1
            if nums[i]==0:
                curr_sum-=1

            # if the particular running sum is not stored yet in hashmap
            # store it along with index
            if val_idx.get(curr_sum,None) is None:
                val_idx[curr_sum] = i
                
            else:
                # set max_len to max of prev max value and difference curr index & prev stored index of this particular sum
                max_len = max(max_len, i-val_idx[curr_sum])

        return max_len
            
            