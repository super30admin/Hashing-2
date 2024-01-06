""" Explanation: I first initiate a hashmap to store the prefix sum to count. Now, I check for the potential pairs before appending to result
    Every time we reach a new prefix_sum, we check sum_to_count[prefix_sum - k] and add it to the result.
    Time Complexcity: O(n)
    Space Complexcity: O(n)
"""

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        result = 0
        prefix_sum = 0
        count_dict = {0: 1}

        for i in range(len(nums)):
            prefix_sum += nums[i]

            if prefix_sum - k in count_dict:
                result += count_dict[prefix_sum - k]

            count_dict[prefix_sum] = count_dict.get(prefix_sum,0) + 1

        return result
        