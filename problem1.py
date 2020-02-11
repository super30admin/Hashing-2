'''
Time Complexity : O(n^2)

Space Complexity : O(1)

Did this code successfully run on Leetcode : No (Time limit on 68th string)

Explanation: Brute force approach to find sum of the subarrays for every start, end values of the subarray and
and hence find every sum for every subsequence and check if equal to k, if yes increment count.
'''

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        for i in range(0, len(nums)):
            sum1 = 0
            for j in range(i, len(nums)):
                sum1 = sum1 + nums[j]
                if sum1 == k:
                    count = count + 1
        return count
