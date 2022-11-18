# Time Complexity: O(N)
# Space Complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Here we use the approach that if the running sum is reapeated then equal number of additions
# and subtractions have taken place between the indices(including the index of last running sum and excluding the first)
# meaning that it should contain equal number of 1s and 0s
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        sum_idx = dict() # to store the running sum of the elements
        sum_curr = 0
        max_window = 0
        # dummy element to take care of cases where the length of array is 2
        sum_idx[0] = -1

        # we add 1 if the element is 1 else we subtract 1, to the running sum
        # if the running sum at the current index is present in our dictionary
        # if differnce of indices of same running same we can update the max_window
        # else we add the running sum to the dict
        for i in range(len(nums)):
            if nums[i] == 0:
                sum_curr -= 1
            else:
                sum_curr += 1

            if sum_curr in sum_idx:
                if((i - sum_idx[sum_curr]) > max_window):
                    max_window = i - sum_idx[sum_curr]
            else:
                sum_idx[sum_curr] = i
        return max_window