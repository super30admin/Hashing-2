class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # Time Complexity: O(n)
        # Space Complexity: O(n)

        # Dictionary to store cumulative sum frequencies
        mapping = defaultdict(int)
        mapping[0] = 1  # To handle subarrays that sum to k starting from index 0

        current_sum = 0  # Running prefix sum
        count = 0        # Number of subarrays that sum to k

        # Iterate through the array
        for num in nums:
            current_sum += num  # Update running sum

            # Check if there exists a prefix sum that matches current_sum - k
            if current_sum - k in mapping:
                count += mapping[current_sum - k]  # Add the frequency of that prefix sum

            # Store or update the frequency of the current_sum
            mapping[current_sum] += 1

        # Return the total count of valid subarrays
        return count
