# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
# - Easy to forget the seed {0: -1} (lets us count subarrays starting at index 0)

# Your code here along with comments explaining your approach
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        n = len(nums)
        rSum = 0                      # running sum where 0 -> -1 and 1 -> +1
        maxLen = 0                    # best (longest) length found so far
        first = {0: -1}               # first index where a given rSum was seen
                                      # start with rSum=0 at index -1 to handle subarrays from index 0

        for i in range(n):            # walk through indices
            if nums[i] == 0:
                rSum -= 1             # treat 0 as -1
            else:
                rSum += 1             # treat 1 as +1

            if rSum in first:
                # If we've seen this rSum before at index j, then the subarray (j+1 .. i)
                # has equal number of 0s and 1s, so its length is i - j.
                maxLen = max(maxLen, i - first[rSum])
            else:
                # Store the FIRST time we saw this rSum (to maximize the subarray length later).
                first[rSum] = i

        return maxLen