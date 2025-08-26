# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach: The code finds the maximum length of a contiguous subarray with equal numbers of 0s and 1s.It treats 0 as -1 and maintains a running sum (rSum), storing the earliest index where each sum occurs in a hashmap. If the same running sum is seen again, it means the subarray between those indices has equal 0s and 1s, and the maximum length is updated.

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        n = len(nums)
        map = {0: -1}
        rSum = 0
        maxLen = 0

        for i in range(n):
            num = nums[i]
            if num == 0:
                rSum -= 1
            else:
                rSum += 1
            
            if rSum in map:
                maxLen = max(maxLen, i - map[rSum])
            else:
                map[rSum] = i
        
        return maxLen