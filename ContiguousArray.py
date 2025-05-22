#Time Complexity: O(N) for Prefix sum
# O(1) for lookup and insertion into Hashmap

#Space: O(N), n is length of the array 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
# Approach: To solve this, calculate the prefix sum by incrementing for 1 and decrementing for 0. Use a hashmap to store the first occurrence of each prefix sum. If the same prefix sum occurs again, the subarray between those indices has an equal number of 0s and 1s, and you update the maximum length.

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        max_length = 0

        #Step 1: calculate Prefix sum
        prefix = [0] * len(nums)
        if nums[0] == 0:
            prefix[0] = -1
        else:
            prefix[0] = 1

        for i in range(len(nums)):
            if nums[i] == 0:
                prefix[i] = prefix[i - 1] - 1
            else:
                prefix[i] = prefix[i - 1] + 1
        #Step 2: Update the hashmap with similar indices
        hash_dict = {0:-1} # Initialize the hashmap with prefix sum 0 at index -1 (this helps with cases where the sum is zero at an index) hash_dict = {0: -1}, you're essentially setting up a baseline to handle edge cases where: A subarray starting from the very first element has a balanced number of 0s and 1s.
        for i in range(len(prefix)):
            if prefix[i] not in hash_dict:
                hash_dict[prefix[i]] = i
            #Step3: Update the max_length variable  
            else:
                new_max = i - hash_dict[prefix[i]]
                max_length = max(max_length, new_max)

        return max_length  