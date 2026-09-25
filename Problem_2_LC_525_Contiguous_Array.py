"""

Time Complexity: O(N), where N is the length of nums.
Space Complexity: O(N), for the running sum hash map.
Did this code successfully run on Leetcode (Problem 525. Contiguous Array) : Yes
Any problem you faced while coding this : None

Approach: Classic running sum / prefix sum pattern. Treat each 0 as -1 and
each 1 as +1, and store each running sum's first index in a hash map.
Whenever the same running sum reappears, the subarray between those two
indices has an equal count of 0s and 1s, so update maxlength accordingly.
Seeding the map with {0: -1} handles the case where the balanced subarray
starts at index 0.

"""

from typing import List


class Solution:


    def findMaxLength(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0

        maxlength = 0
        running_sum_mapping = {0: -1}
        running_sum = 0

        for i in range(len(nums)):
            if nums[i] == 1:
                running_sum += 1
            else:
                running_sum -= 1

            if running_sum in running_sum_mapping:
                maxlength = max(maxlength, i - running_sum_mapping[running_sum])
            else:
                running_sum_mapping[running_sum] = i

        return maxlength


# ---------------------------------------------------------------------------
# Test cases
# ---------------------------------------------------------------------------
if __name__ == "__main__":
    test_cases = [
        ([0, 1], 2),                   # simplest balanced pair
        ([0, 1, 0], 2),                # balanced subarray in the middle
        ([], 0),                       # empty input
        ([0], 0),                      # single element, no balance possible
        ([1], 0),                      # single element, no balance possible
        ([0, 0, 1, 1], 4),             # whole array balanced
        ([0, 1, 1, 0, 1, 1, 1, 0], 4), # mixed counts (3 zeros, 5 ones), not fully balanced
        ([1, 1, 1, 0, 0, 0], 6),       # whole array balanced, grouped
        ([1, 1, 1, 1], 0),             # no zeros, no balance possible
        ([0, 0, 0, 1], 2),             # balanced subarray at the end
        ([1, 0, 0, 1, 0, 0, 1, 1], 8), # whole array balanced (4 zeros, 4 ones)
    ]

    solution = Solution()
    for nums, expected in test_cases:
        result = solution.findMaxLength(nums)
        status = "PASS" if result == expected else "FAIL"
        print(f"{status}: findMaxLength({nums!r}) = {result} (expected {expected})")
