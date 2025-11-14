# Problem 2: Contiguous Array (https://leetcode.com/problems/contiguous-array/)
# Time Complexity: O(N) where N is the number of elements in the input array.
# Space Complexity: O(N) for the hashmap.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No
# Your code here along with comments explaining your approach
# 1. Use a hashmap to store the first occurrence index of each prefix sum.
# 2. Convert 0s to -1s to utilize the prefix sum technique for finding equal number of 0s and 1s.
# 3. For each element, calculate the running sum and check if it has been seen before.
# 4. If it has, calculate the length of the subarray and update the maximum length.
# 5. If it hasn't, store the current index as the first occurrence of this running sum.


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if nums == None or len(nums) ==0:
            return -1
        
        rsum = 0
        Map = {0: -1}
        maxLen = 0

        for i in range(len(nums)):
            if nums[i] == 0:
                rsum = rsum - 1
            else:
                rsum = rsum + 1

            if rsum in Map:
                maxLen = max(maxLen, i - Map[rsum])
            else:
                Map[rsum] = i

        return maxLen