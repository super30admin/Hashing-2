# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        runningSum=0
        map={}
        map[0]=1
        count=0
        for i in range(len(nums)):
            runningSum+=nums[i]
            val=runningSum-k

            if val in map.keys():
                count+=map.get(val)

            if runningSum in map.keys():
                map[runningSum]=map.get(runningSum)+1
            else:
                map[runningSum]=1

        return count

            