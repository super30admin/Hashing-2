# LEETCODE PROBLEM 560 SUBARRAY SUM EQUALS K
# TIME COMPLEXITY:O(N) where N is the number of elements
# SPACE COMPLEXITY: O(N) where N is the space required to make a hashmap of N elements
# Any problem you faced while coding this: None

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        map={0:1}
        runningSum=0
        count=0
        for i in range(len(nums)):
            runningSum+=nums[i]
            diff=runningSum-k
            if diff in map:
                count+=map[diff]
            map[runningSum]=map.get(runningSum,0)+1
        return count

