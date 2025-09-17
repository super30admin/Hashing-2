# Time Complexity : O(n)
# Space Complexity : O(n) storing the running sum and index in hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The intuition is to use the running sum to avoid nested iteration.
# Check the difference between running sum and k provided value and add that to the hashmap.
# If it already exists then increment the count and add the freq to the count result.

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        rSum = 0
        hashmap = {}
        hashmap[0] = 1
        count = 0
        for i in range(len(nums)):
            rSum += nums[i]
            if (rSum - k) in hashmap:
                count += hashmap.get(rSum - k)
            hashmap[rSum] = hashmap.get(rSum, 0) + 1

        return count
