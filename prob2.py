# Contiguous array- https://leetcode.com/problems/contiguous-array/
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        count = 0
        # Adding a default value of -1 for the sum 0 to handle edge cases where the subarray starts from index 0
        freq = {0:-1}
        curSum = 0
        for i,j in enumerate(nums):
            if j==0:
                j = -1 
            # Using running sum to find the longest contiguous subarray with equal number of 0s and 1s. If j values to 0, we treat it as -1
            curSum += j
            if curSum in freq:
                # If the current sum has been seen before, it means we have found a subarray with equal number of 0s and 1s
                # We calculate the length of the subarray and update the count if it's longer than the previous maximum
                count = max(count, i-(freq[curSum]))
            else:
                # If the current sum has not been seen before, we store it with its index
                freq[curSum] = i
        return count


            

        