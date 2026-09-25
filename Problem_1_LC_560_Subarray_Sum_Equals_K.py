"""
Time Complexity: O(N), where N is the length of nums.
Space Complexity: O(N), for the running sum hash map.
Did this code successfully run on Leetcode (Problem 560. Subarray Sum Equals K) : Yes
Any problem you faced while coding this : None

Approach: Running sum / prefix sum pattern. Store how many times each
running sum has occurred in a hash map. At each index, if (running_sum - k)
has occurred before, every one of those occurrences marks the start of a
subarray ending here that sums to k, so add that count to the running
total. Seeding the map with {0: 1} handles subarrays that sum to k
starting from index 0.
"""

from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if nums is None or len(nums) == 0:
            return 0
        running_sum = 0
        running_sum_mapping = {0: 1}
        count = 0

        for i in range(len(nums)):
            running_sum += nums[i]
            if running_sum - k in running_sum_mapping:
                count += running_sum_mapping[running_sum - k]

            if running_sum not in running_sum_mapping:
                running_sum_mapping[running_sum] = 1
            else:
                running_sum_mapping[running_sum] = running_sum_mapping[running_sum] + 1

        return count


# ---------------------------------------------------------------------------
# Test cases
# ---------------------------------------------------------------------------
if __name__ == "__main__":
    test_cases = [
        ([1, 1, 1], 2, 2),                # LeetCode example: [1,1] appears twice
        ([1, 2, 3], 3, 2),                # LeetCode example: [1,2] and [3]
        ([], 0, 0),                       # empty input
        ([1], 1, 1),                      # single element equal to k
        ([1], 0, 0),                      # single element, no match
        ([1, -1, 0], 0, 3),               # negative numbers and zero-sum subarrays
        ([3, 4, 7, 2, -3, 1, 4, 2], 7, 4),# mixed positives/negatives, multiple matches
        ([0, 0, 0, 0, 0], 0, 15),         # all zeros, every subarray sums to 0
        ([1, 2, 1, 2, 1], 3, 4),          # overlapping subarrays summing to k
        ([-1, -1, 1], 0, 1),              # negative numbers cancelling out
    ]

    solution = Solution()
    for nums, k, expected in test_cases:
        result = solution.subarraySum(nums, k)
        status = "PASS" if result == expected else "FAIL"
        print(f"{status}: subarraySum({nums!r}, {k}) = {result} (expected {expected})")