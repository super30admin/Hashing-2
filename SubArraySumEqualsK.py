# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : No

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        rsum = 0
        count = 0
        dict = {0:1}
        for i in range(len(nums)):
            rsum=rsum+nums[i]
            y = rsum-k
            if y in dict:
                count=count+dict[y]
            if rsum not in dict:
                dict[rsum]=1
            else:
                dict[rsum]+=1
        return count