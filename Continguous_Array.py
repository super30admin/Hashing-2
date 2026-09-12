# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
#I have used HashMap to keep the runningSum at each index and store it. 
#If the runningSum already exists then we calculate the longest by subtracting the current index from the previous index in HashMap

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if not nums:
            return None
        dict = {0:-1}
        rSum = 0
        longest = 0
        for i in range(len(nums)):
            if nums[i] == 1:
                rSum += 1
            else:
                rSum -= 1
            if rSum not in dict:
                dict[rSum] = i
            else:
                longest = max(longest, i - dict[rSum])

        return longest