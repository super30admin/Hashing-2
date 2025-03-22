# Time Complexity : O(n) where n is the length of the input string
# Space Complexity : O(n) where n is the length of the input string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# We use a hashmap to store the running sum (prefix sum) at index.
# At each index, we calculate the running sum by adding 1 if the element is 1 and -1 if the element is 0.
# If we find the running sum in the hashmap, we calculate the length of the subarray by subtracting the current index from the index in the hashmap.
# We update the result by taking the maximum of the current result and the length of the subarray.

from collections import defaultdict
from typing import List
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        # Initialize the hashmap to store the running sum at index
        prefixSum = defaultdict(int)
        res = 0
        # Initialize the prefix sum at index 0 as -1 to handle edge cases
        prefixSum[0] = -1
        count = 0
        # Iterate through the input array
        for i in range(len(nums)):
            # Calculate the running sum
            if nums[i] == 0:
                count -= 1
            else:
                count += 1
            # If the running sum is in the hashmap, calculate the length of the subarray
            if count in prefixSum:
                # Update the result by taking the maximum of the current result and the length of the subarray
                res = max(res, i - prefixSum[count])
            else:
                # Store the running sum at index in the hashmap
                prefixSum[count] = i
        return res