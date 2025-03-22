# Method: Prefix Sum + HashMap
# Time Complexity: O(N) Single pass through the array.
# Space Complexity: O(N) Storing prefix sums in a hashmap (worst-case N unique sums).

from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        curr_sum = 0
        pref_sum = {0: 1}  # Dictionary to store prefix sum frequencies
        count = 0

        for num in nums:
            curr_sum += num  # Update running sum

            # Check if (curr_sum - k) exists in pref_sum dictionary
            # If it does, it means there is a subarray that sums to k
            if curr_sum - k in pref_sum:
                count += pref_sum[curr_sum - k]

            # Update the prefix sum count in the dictionary
            if curr_sum in pref_sum:
                pref_sum[curr_sum] += 1
            else:
                pref_sum[curr_sum] = 1

        return count  # Return total count of subarrays summing to k


sol = Solution()
nums = [0, 1, 0, 1, 1, 0, 1, 1]
k = 2  # Target sum
print("Number of subarrays with sum", k, ":", sol.subarraySum(nums, k))
