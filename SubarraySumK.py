## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def subarraySum(nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        rSum = 0
        count = 0
        hMap = {0: 1}

        for num in nums:
            rSum = rSum + num
            if rSum - k in hMap:
                count = count + hMap[rSum - k]
            if rSum in hMap:
                hMap[rSum] = hMap[rSum] + 1
            else:
                hMap[rSum] = 1

        return count

    nums = [1,1,1]
    k = 2
    print(subarraySum(nums, k))