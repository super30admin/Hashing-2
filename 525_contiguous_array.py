'''
## Problem 525: Contiguous array

## Author: Neha Doiphode
## Date:   07-01-2022

## Description:
    Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

## (Notes): Possible approaches could be
    * hashing, binary search, two pointers, sliding windo

## Approach: (Used below)
    * Running sum:
        It is not an algorithm paradigm but a technique which can be used to solve several similar problems.


## Examples:
    Example 1:
        Input: nums = [0,1]
        Output: 2
        Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

    Example 2:
        Input: nums = [0,1,0]
        Output: 2
        Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

    Example 3:
        Input: nums = [0,1,0,1]
        Output: 4
        Explanation: [0, 1, 0, 1] is a longest contiguous subarray with equal number of 0 and 1.

    Example 4:
        Input: nums = [0,0,1,0,0,0,1,1]
        Output: 6
        Explanation: [1, 0, 0, 0, 1, 1] is a longest contiguous subarray with equal number of 0 and 1.

    [0,1,1,0,1,1,1,0]

## Time complexity: O(n), as we need to traverse the array at least once.

## Space complexity: O(n), Auxiliary hash map is created and that will have n number of entries
                           in case we have all zeros or all ones. In such a case, running sum will constantly change.
                           and a new entry will be added to the map.

'''

from typing import List

def get_input():
    print()
    print("Enter the list of 0s and 1s with spaces: ", end = "")
    inp_list = input()
    inp_list = [int(num) for num in inp_list.split()]
    return inp_list

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:

        # Declare a max_length variable to store max contiguous subarray length
        max_length = 0

        # Declare a map to store running sum at a particular index
        # Key = running sum
        # Value = index at which a particular running some exists
        running_sum_index_map = dict()

        # Declare a running sum variable to track the current running sum at a particular index
        # we initialize it to zero.
        running_sum = 0

        # Now, with that setup, we should start running over the loop
        for index, num in enumerate(nums):

            # whenever we encounter zero we subtract 1 from the running sum
            if num == 0:
                running_sum -= 1
            else:
                running_sum += 1

            # Now check if total running sum is 0.
            # If yes, we know that we have equal number of 0's and 1's so far
            # thats why the they nullify each other and total running sum becomes 0.
            # Change max length of the sub array to current_index + 1 in that case
            if running_sum == 0:
                max_length = index + 1

            # Now we need to update the max_length based on previously encoutered lengths of subarrays
            # to make sure, that we did not have any previous sub array which had length more than current max length.
            # To do so, check if have already stored all running sums encountered so far with respective sub array indices
            # Make use of hash map to store it.

            if running_sum in running_sum_index_map:
                # if the sum was encountered previously,
                # Check what was sub array length at the time sum was encountered.
                # And compare it with the current max length
                # if we had longer sub array before, then we update the max_length
                # else we don't
                if max_length < index - running_sum_index_map[running_sum]:
                    max_length = index - running_sum_index_map[running_sum]

            else:
                # Add the running sum value to the index map
                # Map it to the length of sub-array so far
                running_sum_index_map[running_sum] = index

        return max_length




# Driver code
solution = Solution()
inp_list = get_input()
print(f"Original input list: {inp_list}")
print(f"Longest contiguous subarray with equal number of 0s and 1s length: {solution.findMaxLength(inp_list)}")
print()
