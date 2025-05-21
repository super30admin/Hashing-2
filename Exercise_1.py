"""
Time - O(n)
Space - O(n)

"""

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:

        count = 0
        running_sum = 0
        prefix_counts = {0: 1}

        for num in nums:
            running_sum += num
            count += prefix_counts.get(running_sum - k, 0)
            prefix_counts[running_sum] = prefix_counts.get(running_sum, 0) + 1

        return count

        