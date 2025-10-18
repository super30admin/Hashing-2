class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # Map to store frequency of prefix sums encountered so far.
        # Start with {0: 1} because if a subarray itself equals k,
        # (rSum - k == 0), it should count once.
        prefixSumCount = {0: 1}

        currentSum = 0   # Running (prefix) sum
        totalSubarrays = 0  # Number of subarrays whose sum == k

        # Loop through each number in the array
        for num in nums:
            # Add the current number to the running sum
            currentSum += num

            # The sum we need to find in the past prefix sums to form a valid subarray
            requiredSum = currentSum - k

            # If that required sum exists, it means there are one or more
            # subarrays ending here that sum up to k
            if requiredSum in prefixSumCount:
                totalSubarrays += prefixSumCount[requiredSum]

            # Record the current prefix sum in the map
            # If it exists, increment the count
            prefixSumCount[currentSum] = prefixSumCount.get(currentSum, 0) + 1

        # Return total count of valid subarrays
        return totalSubarrays

