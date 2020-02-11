'''
Time Complexity : O(n^2)

Space Complexity : O(1)

Did this code successfully run on Leetcode : No (Time limit)

Explanation: Brute force approach to find count of 1's and 0's  of the subarrays for every start, end values of the subarray
and then check if count(0) == count(1) if yes then set count of longest subarray as maxCount = max(maxCount, end-start+1)
'''
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        count = 0

        for i in range(0, len(nums)):
            zero = 0
            one = 0
            for j in range(i, len(nums)):

                if nums[j] == 0:
                    zero = zero + 1

                if nums[j] == 1:
                    one = one + 1

                if zero == one:
                    count = max(count, j - i + 1)

        return count