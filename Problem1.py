#Time Complexity : O(n)
#Space Complexity : O(n)
#Any problem you faced while coding this :none
#Your code here along with comments explaining your approach
class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        no_of_subarrays=0
        running_sum=0
        compliment_sum=0
        my_hash_map={0:1}
        for num in nums:
            running_sum+=num  # keep track of the running sum 
            compliment_sum=running_sum-k 
            if compliment_sum in my_hash_map: # if the compliment sum is found before among the running sums then that subarray would give the target
                no_of_subarrays+=my_hash_map[compliment_sum]  # increment the number of subarrays by the count of number of times the target is found
            if running_sum in my_hash_map: # if the running sum is already present in the hashmap then increment the count
                my_hash_map[running_sum]+=1
            else:
                my_hash_map[running_sum]=1  # else start counting 
        return no_of_subarrays    # return the number of subarrays