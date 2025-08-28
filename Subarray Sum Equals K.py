# Time Complexity : O(N) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using a hashmap to store the running sum and its frequency. I will iterate through the array and update the running sum.
# If the running sum is already in the hashmap, it means we have found a subarray with sum equal to k.
# We will update the count accordingly. If not, we will add the running sum and its frequency to the hashmap.
# In the return the number of subarrays found.

from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hashmap = {0:1}
        ans = 0
        sumy = 0
        for i in range(len(nums)):
            sumy += nums[i]
            rem = sumy - k
            ans += hashmap.get(rem,0)
            hashmap[sumy] = hashmap.get(sumy,0) + 1
        return ans



        