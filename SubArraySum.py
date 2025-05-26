# Time Complexity: O(n), n is the number of elements in nums arrays
# Space Complexity: O(n), n is the number of elements in nums arrays
# Did this code successfully run on Leetcode: Yes

# I am using a running sum in hash map and at every index iam checking running sum - target is in hash_map
# if it is in hash map, I am increasing the count by one

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        running_sum = 0
        hash_map = {}
        hash_map[0] = 1
        count = 0


        for num in nums:
            running_sum += num

            deficit = running_sum - k

            if deficit in hash_map:
                count += hash_map[deficit]

            if running_sum in hash_map:
                hash_map[running_sum] += 1
            else:
                hash_map[running_sum] = 1
        
        return count