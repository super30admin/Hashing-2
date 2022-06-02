"""
TC:O(n)
SC: O(n)
"""
from collections import defaultdict
class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        count_dict = defaultdict(int)
        count_dict[0] = 1
        cumulative_sum = 0
        count = 0
        for num in nums:
            cumulative_sum += num
            if cumulative_sum - k in count_dict:
                count += count_dict[cumulative_sum - k]
            count_dict[cumulative_sum] += 1
            
        return count
            
