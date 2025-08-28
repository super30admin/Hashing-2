# Time Complexity : O(N) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using a hashmap to store the running sum and its index. I will iterate through the array and update the running sum.
# If the running sum is already in the hashmap, it means we have found a subarray with equal number of 0s and 1s.
# We will update the maximum length accordingly. If not, we will add the running sum and its index to the hashmap.
# In the return the maximum length found.

from ast import List


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hashmap = {0:-1}
        rsum = 0
        ans = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                rsum -= 1
            else:
                rsum += 1
            if rsum in hashmap:
                curr = i - hashmap[rsum]
                ans  = max(curr,ans)
            else:
                hashmap[rsum] = i
        return ans
        