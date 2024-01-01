# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Problem2 (https://leetcode.com/problems/contiguous-array/)
# Iterating through the array, then we get the current number from the array so that we can increment or decrement cumulative_sum based on the value of num
# We check to see if the culmative sum is in our map and if so we salculate the length of the current balanced subarray and then update the max_length if current_length is greater
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        sum_map = {0: -1}  
        max_length = 0 
        cumulative_sum = 0
        for index in range(len(nums)):
            num = nums[index]

            if num == 1:
                cumulative_sum += 1
            else:
                cumulative_sum -= 1

            if cumulative_sum in sum_map:
                current_length = index - sum_map[cumulative_sum]
                max_length = max(max_length, current_length)
            else:
                sum_map[cumulative_sum] = index

        return max_length