# // Time Complexity : O(n)
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : yes, refered the video one more time.
class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # find the sum of the subarray whihc is equal to k
        # brute force: make sub arrays and check if sum is euqal to k
        # optimal appoach : we need the number of subarrays possible in the given array which the sum is k 
        # so lets have the cumultive sum at each index and keep checking the cumlative sum at index x -k is that value is present in our hashmp then we know we found
        # a subarray where the sum of this subarray is k 
        # why hashmp, hashmap is to save the sum and how many times that culative sum has come across so we can have the count of subarrays with sum k

        # sc O(n)
        hash_map = {} # storing the cumilative sum and its count of times this sum has come in the array

        cumulative_sum = 0

        count = 0

        hash_map[0] = 1 # dummy prefix, that before starting that we saw the sum 0 once , because before parsing any elements in the array the sum is 0 


        for i in range(len(nums)): # tc O(n)
            cumulative_sum += nums[i]
            complimatary_sum = cumulative_sum -k 

            if complimatary_sum in hash_map: # tc O(1)
                count += hash_map[complimatary_sum] # increment the count by number of times we foudn the complimatray sum in the map
                
            # tc O(1)
            hash_map[cumulative_sum] = hash_map.get(cumulative_sum, 0) + 1 # if the sum already ecisst we get that value and increment with 1, and if nto then it returns 0 and +1 , as this is the first time we saw this sum


        return count
