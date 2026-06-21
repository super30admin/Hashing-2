'''
The logic is same as problem 1. If we see 0 as -1 then the cumSum will
be 0 for the subarray that has equal numbers of 0s and 1s.

Also the cumSum can be same for each subarray in the beginning and end if it has
equal numbers of 0s and 1s.

We check if the cumSum has apperead before in the hMap and store the earliest location
of a cumSum in order to get the max length.

When the cumSum is 0 then the length of the subarray will be equal to the index + 1,
hence we add 0: -1 to the hMap prior to the loop in order to cover this edge case.
Time Complexity: O(n)
Space complexity: O(n)
'''

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        cumSumMap = {0: -1}
        cumSum = 0
        maxLen = 0

        for i, num in enumerate(nums):
            if num == 0:
                cumSum += -1
            else:
                cumSum += 1

            if cumSum in cumSumMap:
                maxLen = max(maxLen, i - cumSumMap[cumSum])
            else:
                cumSumMap[cumSum] = i

        return maxLen