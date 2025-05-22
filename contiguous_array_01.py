# Replace 0 with -1 and find the longest subarray with sum = 0 using prefix sums.
# Use a hashmap to store the earliest index where each running sum occurred.
# The length between current index and stored index of same sum gives a balanced subarray length.
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        sum_to_index = {0: -1}  # Map running_sum to earliest index, start with 0 at -1
        running_sum = 0
        maxlen = 0

        for i, num in enumerate(nums):
            running_sum += 1 if num == 1 else -1  # Treat 0 as -1 to find balanced subarrays

            if running_sum in sum_to_index:
                maxlen = max(maxlen, i - sum_to_index[running_sum])  # Update max length if seen sum before
            else:
                sum_to_index[running_sum] = i  # Record index of first occurrence

        return maxlen
