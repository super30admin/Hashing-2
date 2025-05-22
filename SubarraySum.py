#Time Complexity : O(N)
#Space Complexity : O(N)

#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
 

#Approach: Calculate the current prefix sum and Check if there is any previous prefix sum that equals prefix_sum - target

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        target = k
        prefix_sum = 0
        count = 0
        hash_map = {0: 1}  # Initialize with prefix sum 0, which helps handle subarrays from the start
        
        for num in nums:
            prefix_sum += num  
            if prefix_sum - target in hash_map:
                count += hash_map[prefix_sum - target]
            
            # Update the hashmap with the current prefix sum
            if prefix_sum in hash_map:
                hash_map[prefix_sum] += 1
            else:
                hash_map[prefix_sum] = 1
        
        return count
        