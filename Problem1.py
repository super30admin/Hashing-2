# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#Approach: 1. We initiate a prefixMap to keep track of running sum freq, starting with rSum = 0 to avoid missing out first rSum -k = 0 occurance, along with count var that tracks subarrays seen so far.
#          2. Whenever we find a diff, that's been seen already, its freq gives us the combinations of subarrays possible at the current index and we just add that freq to the count and add the current rSum to hashmap for future refernce.
#          3. At the end, we return the count


from collections import defaultdict
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        rSum = 0
        count = 0
        prefixMap = defaultdict(int, {0:1})

        for num in nums:
            rSum += num
            diff = rSum - k
            if diff in prefixMap:
                count += prefixMap[diff]
            prefixMap[rSum] += 1
        return count