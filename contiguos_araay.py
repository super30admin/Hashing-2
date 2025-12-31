"""
time - o(n)
space - o(n)
We take the running sum with every 0 as -1 and 1 as +1 to the running sum
As and when we hit 0 as the running sum, the number of 1s and 0s are balanced.
similarly, if the sum is the same between two indices then the 0s and 1s between
those indices are balanced. So we keep the running sum as key and the index where it
was first seen as value in a dictionary. The difference between the two indices is the length
of the subarray.
we then update a max tracker variable and return the same
"""
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        running_sum = 0
        sum_dict = {0:-1}
        max_subarray_len = -1
        for i in range(len(nums)):
            if nums[i] == 0:
                running_sum-=1
            else:
                running_sum+=1
            if running_sum not in sum_dict:
                sum_dict[running_sum]=i
            else:
                max_subarray_len = max(max_subarray_len, i-sum_dict[running_sum])
        if max_subarray_len == -1:
            return 0
        return max_subarray_len
            
            
        