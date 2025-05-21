# We use a running count, incrementing for 1 and decrementing for 0, to track the difference between the number of 1s and 0s.
# A hashmap stores the earliest index where each count value is seen, allowing us to find subarrays with equal 0s and 1s efficiently.
# When the same count is seen again, the subarray between the previous and current indices has equal numbers of 0s and 1s, and we update the maximum length.

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        count_index = {0: -1}
        max_length = 0
        count = 0
        for i, num in enumerate(nums):
            count += 1 if num == 1 else -1
            if count in count_index:
                max_length = max(max_length, i - count_index[count])
            else:
                count_index[count] = i
        return max_length
        