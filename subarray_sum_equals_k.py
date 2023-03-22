# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""In this code we are using hashmap to store the running sum and the number of times it has occured. 
We are also using a variable called difference which is the difference between the running sum and the target sum. 
We are incrementing the answer by the number of times the difference has occured in the hashmap. """

import collections

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if nums == None or len(nums) == 0:
            return 0

        if len(nums) == 1 and nums[0] == k:
            return 1
        elif len(nums) == 1 and nums[0] != k:
            return 0

        rSum = 0
        hashmap = collections.defaultdict(int)
        hashmap[0] += 1
        answer = 0

        for i in range(len(nums)):
            rSum += nums[i]
            difference = rSum - k
            answer += hashmap[difference]
            hashmap[rSum] += 1

        return answer
