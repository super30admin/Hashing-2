"""
TC: O(N) {we iterate through the array once}
SC: O(N) {at worst-case, we can have an array of all 1s, that will give us the SC of O(N)}

Approach:

We eliminate the subarray method by introducing a running sum along with a hashmap (storing indices) to search effeciently. We add 1 for every one we 
encounter and subtract 1 for every 0. If at any point the running sum gets 0, that means the subarray is balance, we update the
res. Also,if the curr running sum was there already in the hashmap, we again update res with the diff between that idx and the curr idx

This problem ran successfully on Leetcode.
"""

from typing import List

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        
        curr = 0
        res = 0
        d1 = {}
        for i in range(len(nums)):
            
            if nums[i] == 0:
                curr -= 1
            else:
                curr += 1

            if curr == 0:
                res = max(res, i+1)
                
            if curr in d1:
                res = max(res, i-d1[curr])
            else:
                d1[curr] = i

        return res
            