""" Explanation: count keeps track of the difference between the number of 0s and 1s encountered so far.
                 result stores the maximum length of a contiguous subarray with an equal number of 0s and 1s.
                 dict_seen is a hashmap that stores the count as a key and the index where it was first encountered as the value.
    Time & Space Complexcity: O(n)
"""

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # variables to store the counts of 0 and 1, and for the result
        # a hashmap to store the frequencies
        count, result = 0 , 0
        dict_seen = {0:-1}
        for i in range(len(nums)):
            n = nums[i]
            if n == 0:
                count -= 1
            if n == 1:
                count += 1

            if count in dict_seen:
                result = max(result, i-dict_seen[count])
            else:
                dict_seen[count] = i
        
        return result

        