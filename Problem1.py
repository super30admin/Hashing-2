# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Identifying the algo
# We iterate through the nums list and keep a running sum of elements from the start, we calculate the difference 
# between thge current cumulative sum and k and if the diffenrence is in our hashmap it emplys there are prefix[diff] subarrays, thier total sum becomes k and added to res
# we then update prefix
# Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res = 0
        current = 0
        prefix = {0:1}
        for x in nums:
            current = current + x
            diff = current - k
            res = res + prefix.get(diff, 0)
            prefix[current] = 1 + prefix.get(current,0)
        return res
    