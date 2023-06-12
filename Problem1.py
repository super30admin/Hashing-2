class Solution(object):
    def subarraySum(self, nums, k):
        """
        Time complexity - O(n) n --> len(nums)
        space complexity - O(n)
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        rSumMap = {}  # Create a dictionary to store running sums and their frequencies
        # Initialize the dictionary with a running sum of 0 and frequency 1
        rSumMap[0] = 1
        rSum = 0  # Initialize the running sum
        count = 0  # Initialize the count of subarrays with sum k

        for i in range(len(nums)):
            # Calculate the running sum by adding the current element
            rSum += nums[i]

            if (rSum - k) in rSumMap:
                # If the complement of the current running sum (rSum - k) is present in the dictionary,
                # it means there exists a subarray with sum k. Increment the count by the frequency of the complement.
                count += rSumMap[rSum - k]

            if rSum in rSumMap:
                # If the current running sum is already in the dictionary, increment its frequency
                rSumMap[rSum] += 1
            else:
                # If the current running sum is not in the dictionary, add it with frequency 1
                rSumMap[rSum] = 1

        return count
