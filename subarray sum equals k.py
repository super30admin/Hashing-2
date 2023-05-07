 # Time Complexity : o(n)
 # Space Complexity : o(1)
 # Did this code successfully run on Leetcode : yes
 # Any problem you faced while coding this : No
 #
 #
 # Your code here along with comments explaining your approach
 class Solution:
     def subarraySum(self, nums: List[int], k: int) -> int:
         di = {}
         rsum = 0
         di[0] = 1
         count = 0
         for i in range(len(nums)):
             rsum = rsum + nums[i]
             if (rsum - k) in di:
                 count = count + di[rsum - k]
             if rsum not in di:
                 di[rsum] = 1
             else:
                 di[rsum] = di[rsum] + 1

         return count