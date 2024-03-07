# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : No

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        dict = {0:-1}
        rsum = 0
        count = 0
        
        for i in range(len(nums)):
            if nums[i]==0:
                rsum-=1
            else:
                rsum+=1
            if rsum not in dict:
                dict[rsum]=i
            else:
                diff = i-dict[rsum]
                count = max(count,diff)
        return count