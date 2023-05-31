"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res={0:1}
        count=0
        ans=0

        for i in range(len(nums)):
            count+=nums[i]
            if count-k in res:
                ans+=res[count-k]
                # res[count-k]-=1
            
            if count in res:
                res[count]+=1
            else:
                res[count]=1
        return ans