## Problem2 (https://leetcode.com/problems/contiguous-array/)
# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        s = 0
        l = 0
        d = {0:-1}
        for i in range(len(nums)):
            print(i)
            if nums[i]==0:
                s -= 1
            else:
                s += 1
            if s not in d:
                d[s] = i
            else:
                l = max(l, i - d[s])
        return l