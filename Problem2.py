#Time Complexity : O(n)
#Space Complexity : O(n)
#Any problem you faced while coding this :none
#Your code here along with comments explaining your approach
class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        running_sum=0
        max_length=0
        my_hash_map={}
        for i in range(len(nums)):
            if nums[i]==0:
                running_sum-=1  # if the value is zero subtract -1
            else:
                running_sum+=1  # if the value is 1 add 1
            if running_sum==0:   # condition to check of the running sum is zero that update the length
                max_length=max(max_length,i+1)
            if running_sum in my_hash_map:  # if the running sum is in the hashmap then calculate the new length
                new_diff=i-my_hash_map[running_sum]
                max_length=max(max_length,new_diff)
            else:                            # else add the running sum and the mapping to the index in the hashmap
                my_hash_map[running_sum]=i
        return max_length