# Track the running sum while iterating through the array.
# For each sum, check if (current_sum - k) has been seen before — that means a subarray sums to k.
# Use a hashmap to count prefix sums for efficient O(n) lookup and update.

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefixSumCount = {0: 1}
        running_sum = 0
        count = 0

        for num in nums:
            running_sum += num
            count += prefixSumCount.get(running_sum - k, 0)
            prefixSumCount[running_sum] = prefixSumCount.get(running_sum, 0) + 1

        return count