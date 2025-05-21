"""
Time - O(n)
Space - O(n)

"""

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        running_sum = 0
        max_len = 0
        sum_indices = {0: -1}  # sum: first_index

        for i, num in enumerate(nums):
            running_sum += 1 if num == 1 else -1
            
            if running_sum in sum_indices:
                length = i - sum_indices[running_sum]
                max_len = max(max_len, length)
            else:
                sum_indices[running_sum] = i  # only store the first occurrence

        return max_len
