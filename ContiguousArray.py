# Time Complexity : O(n)
# Space Complexity : O(n) storing the running sum and index in hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The intuition here is to have the running sum to avoid nested iteration.
# Then add them to hashmap and then check if the same running sum exists further down the array
# Then calculate the currLength and if it's greater than maxLen, then update max length.

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hashmap = {}
        hashmap[0] = -1
        rSum = 0
        maxLen = 0
        for i in range(len(nums)):
            if(nums[i] == 0):
                rSum -= 1
            else:
                rSum += 1
            if rSum in hashmap:
                currLen = i - hashmap[rSum]
                maxLen = max(maxLen, currLen)
            else:
                hashmap[rSum] = i

        return maxLen