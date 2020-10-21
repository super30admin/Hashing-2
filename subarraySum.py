#Time Complexity : O(n) where n is the length of input array
#Space Complexity : O(n) where n is the length of input array
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        #optimized
        sum_counts = {0: 1}
        running_sum = 0
        ans = 0

        for i in range(len(nums)):
            running_sum += nums[i]
            ans += sum_counts.get(running_sum-k, 0)
            sum_counts[running_sum] = sum_counts.get(running_sum, 0) + 1

        return ans

        #brute force - TC - O(n^2), SC - O(1)
#         ans = 0
#         for i in range(len(nums)):
#             running_sum = 0
#             for j in range(i, len(nums)):
#                 running_sum += nums[j]
#                 if running_sum == k:
#                     ans += 1

#         return ans
