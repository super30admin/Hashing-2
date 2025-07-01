# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def findMaxLength(self, nums):
        if len(nums) == 0 or len(nums) == 1:
            return 0
        run_score_map = {}
        rsum = 0
        max_len = 0
        run_score_map[0] = -1
        for i in range(len(nums)):
            if nums[i] == 0:
                rsum = rsum - 1
            else:
                rsum = rsum + 1
            if rsum in run_score_map: 
                max_len = max(max_len, i - run_score_map[rsum])
            else:
                run_score_map[rsum] = i
        return max_len

#obj = Solution()
#sol1 = obj.findMaxLength([0,1])
#print(sol1)
#sol2 = obj.findMaxLength([0,1,0])
#print(sol2)
#sol3 = obj.findMaxLength([0,1,1,1,1,1,0,0,0])
#print(sol3)        