# Time Complexity: O(n), n is the number of elements in nums arrays
# Space Complexity: O(n), n is the number of elements in nums arrays
# Did this code successfully run on Leetcode: Yes



class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        running_sum = 0
        hash_map = {}
        hash_map[0] = -1
        length = 0

        for index in range(len(nums)):
            if nums[index]:
                running_sum += 1
            else:
                running_sum -= 1
            
            if running_sum in hash_map:
                current_length = index - hash_map[running_sum]
                length = max(length, current_length)
            else:
                hash_map[running_sum] = index
        
        return length
