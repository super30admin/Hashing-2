# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach in three sentences only

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # Create a hashmap to store the running sum as key and frequency as value
        tmap = {}
        # Initialize count to keep track of valid subarrays
        count = 0
        # Initialize running sum to 0
        rsum = 0
        # Add an initial entry in the hashmap: sum 0 has occurred once,This helps to handle the case when a subarray starts from index 0
        tmap[0] = 1
        # Loop through each element in the input array
        for i in range(len(nums)):
            # Update running sum by adding the current number
            rsum = rsum + nums[i]

            # Calculate the difference between running sum and target k
            diff = rsum - k

            # If this difference has been seen before, it means there's a subarray that sums to k
            if diff in tmap:
                # Add the frequency of that sum to the count
                count = count + tmap[diff]

            # Update the hashmap with the current running sum, If it already exists, increment the count; otherwise, initialize it to 1
            tmap[rsum] = tmap.get(rsum, 0) + 1

        # Return the total number of subarrays found that sum to k
        return count
