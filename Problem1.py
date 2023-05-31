# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We use a running sum and also keep track of the number of occurences of previous running sums, 
# in order to easily calculate the complement's frequency. This helps us find the number of subarrays that
# have sum equal to the input k.

from collections import defaultdict

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res = 0
        m = defaultdict(int)
        rSum = 0
        m[0] = 1
        for n in nums:
            rSum += n
            res += m[rSum-k]
            m[rSum] += 1
        return res