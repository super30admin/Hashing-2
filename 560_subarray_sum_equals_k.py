'''
## Problem 560: Subarray Sum Equals K

## Author: Neha Doiphode
## Date:   07-01-2022

## Description:
    Given an array of integers nums and an integer k,
    return the total number of subarrays whose sum equals to k.

    A subarray is a contiguous non-empty sequence of elements within an array.

## Examples:
    Example 1:
        Input: nums = [1,1,1], k = 2
        Output: 2

    Example 2:
        Input: nums = [1,2,3], k = 3
        Output: 2

    Example 3:
        Input: nums = [1,2,1,2,1], k = 3
        Output: 4

    Example 4:
        Input: nums = [-1,-1,1], k = 0
        Output: 1



## Constraints:
    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107

## Time complexity: O(n), we traverse the array.

## Space complexity: O(n), Auxiliary map is required to store rSum and count.
                           Length of the map is same as length of the input array.

'''
from typing import List

def get_input():
    print()
    print("Enter the integer array elements with spaces: ", end = "")
    inp_list = input()
    inp_list = [int(num) for num in inp_list.split()]
    print("Enter the target sum: ", end = "")
    k = int(input())
    return inp_list, k

class Solution:

    ################ Brute force ##################
    ############ Time limit exceeded ##############
    def subarraySum_brute_force(self, nums: List[int], k: int) -> int:
        running_sum = 0
        running_sum_index_map = [0] * len(nums)
        sub_array_counter = 0

        for index, value in enumerate(nums):
            running_sum += value
            running_sum_index_map[index] = running_sum

            if running_sum == k:
                sub_array_counter += 1

            cnt = index - 1
            while cnt >= 0:
                if (running_sum_index_map[index] - running_sum_index_map[cnt]) == k:
                    sub_array_counter += 1
                cnt -= 1

        return sub_array_counter

    def subarraySum(self, nums: List[int], k: int) -> int:
        running_sum = 0
        running_sum_count_map = dict()
        sub_array_counter = 0

        running_sum_count_map[running_sum] = 1

        for value in nums:
            running_sum += value

            if (running_sum - k) in running_sum_count_map:
                sub_array_counter += running_sum_count_map[(running_sum - k)]

            if running_sum not in running_sum_count_map:
                    running_sum_count_map[running_sum] = 0
            running_sum_count_map[running_sum] += 1

        return sub_array_counter


# Driver code
solution = Solution()
inp_list, k = get_input()
print(f"Original input array: {inp_list}")
print(f"Target sum: {k}")
print(f"Number of contiguous subarrays with target sum {k}: {solution.subarraySum(inp_list, k)}")
print()
