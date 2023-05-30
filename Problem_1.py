"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res=0
        curSum=0
        presum={0:1}

        for n in nums:
            curSum+=n
            diff=curSum-k
            res+=presum.get(diff,0)
            presum[curSum]=1+presum.get(curSum,0)
        return res