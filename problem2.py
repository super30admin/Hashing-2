# Brute force - We can get all the subarrays of the given list and then check if the subarray has equal 0s and 1s. Find the one which is the longest. Return its length.
# Solved using running sum pattern
# Time complexity - O(n) - we have to iterate the entire nums array
# Space complexity - O(n) - we can have n different running sums
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        rsum_index_dict={0:-1}

        rsum=0
        maxlength=0
        for i in range(0,len(nums)):
            if nums[i]==0:
                rsum=rsum-1
            else:
                rsum=rsum+1
            
            if rsum in rsum_index_dict:
                maxlength=max(maxlength,i-rsum_index_dict[rsum])
            else:
                rsum_index_dict[rsum]=i
        return maxlength