#Time Complexity : O(n) where n is the length of input array
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
#optimized
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        runningSum, maxLen = 0, 0
        sum_indices = {0: -1}

        for i in range(len(nums)):
            if nums[i] == 0:
                runningSum -= 1
            else:
                runningSum += 1

            if runningSum in sum_indices:
                maxLen = max(maxLen, i - sum_indices[runningSum])

            else:
                sum_indices[runningSum] = i

        return maxLen


#brute force - TC- O(n^2) SC - O(1)
# class Solution:
#     def findMaxLength(self, nums: List[int]) -> int:
#         max_len = 0
#
#         for i in range(len(nums)):
#             zeroes, ones = 0, 0
#             for j in range(i, len(nums)):
#                 if nums[j] == 0:
#                     zeroes += 1
#                 else:
#                     ones += 1
#
#                 if zeroes == ones:
#                     max_len = max(max_len, j-i+1)
#
#         return max_len
