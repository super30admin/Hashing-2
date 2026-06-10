## Problem2 (https://leetcode.com/problems/contiguous-array/)
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        """
        Time Complexity: O(N)
        - We iterate through the `nums` array exactly once. Hash map lookups and insertions take O(1) time on average.
        
        Space Complexity: O(N)
        - In the worst-case scenario (e.g., an array of all 1s or all 0s), the `sumMap` will store a unique running sum for every element in the array.
        """
        
        # rSums = []  <-- Note: This is unused and can be safely removed!
        rSum = maxCount = 0
        
        # Dictionary to store the FIRST occurrence of a running sum.
        # Key = running sum, Value = index where it was first seen
        sumMap = dict()
        
        # Base case: Initialize the map with a running sum of 0 at index -1.
        # This properly handles valid subarrays that start from the very beginning (index 0).
        sumMap[0] = -1

        for i, n in enumerate(nums):
            # Treat 0 as -1 and 1 as +1. 
            # This way, an equal number of 0s and 1s will cancel out to a net sum of 0.
            if n == 0:
                rSum -= 1
            else:
                rSum += 1

            # If we've seen this running sum before, it means the numbers between 
            # that previous index and our current index 'i' balanced each other out to 0.
            if rSum in sumMap:
                # Calculate the length of this balanced subarray and update maxCount if it's the longest so far.
                maxCount = max(maxCount, i - sumMap.get(rSum))
            else:
                # We only record the running sum if it's not already in the map.
                # Keeping the earliest index guarantees we find the MAXIMUM length.
                sumMap[rSum] = i

        return maxCount