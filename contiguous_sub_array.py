# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach in three sentences only

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        # Initialize a hashmap to store the first occurrence index of each running sum
        # Key: running sum, Value: index at which it first occurred
        # Start with {0: -1} to handle the case when the subarray starts at index 0
        tmap = {0: -1}
        # Running sum, initialized to 0
        rsum = 0
        # Variable to keep track of the maximum length found
        maximum = 0
        # Temporary variable to store current subarray length when found
        tmp = 0
        # Iterate through the list
        for i in range(len(nums)):
            # If O found subtract -1 from running sum
            if nums[i] == 0:
                rsum = rsum - 1
            # Add 1 if anything apart from 0 is found
            else:
                rsum = rsum + 1
            # If the current running sum has been seen before
            if rsum in tmap:
                # The subarray between the previous index and current index has equal 0s and 1s
                tmp = i - tmap[rsum]
                # Update the maximum length if this subarray is longer
                maximum = max(maximum, tmp)
            else:
                # If this running sum hasn't been seen, store the index where it first occurred
                tmap[rsum] = i
        # Return the maximum length of a balanced subarray found
        return maximum
