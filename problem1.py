# https://leetcode.com/problems/subarray-sum-equals-k/

# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        table = {0: 1}  # Prefix Sum and Frequency
        count, result = 0, 0
        for i in range(0, len(nums)):
            count += nums[i]
            target = count - k  # this check has to be done before inserting because if k == 0 it will fail.
            if target in table:
                result += table[target]
            if count not in table:
                table[count] = 0
            table[count] += 1
        print(table)
        return result
