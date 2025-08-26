# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach: This code counts the number of subarrays whose sum equals k. It keeps a running sum (rSum) while iterating, and uses a hashmap to store how many times each prefix sum has occurred. For each element, if rSum - k exists in the hashmap, it means a subarray ending at the current index sums to k, so the result is incremented accordingly.

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        result = 0
        rSum = 0
        hmap = {0:1}

        for num in nums:
            rSum += num
            diff = rSum - k
            if diff in hmap:
                result += hmap[diff]
            hmap[rSum] = hmap.get(rSum, 0) + 1
        
        return result