class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        prefix = {0: -1}
        currSum = 0
        maxLen = 0

        for i, num in enumerate(nums):

            if num == 0:
                currSum -= 1
            else:
                currSum += 1

            if currSum in prefix:
                maxLen = max(maxLen, i - prefix[currSum])
            else:
                prefix[currSum] = i

        return maxLen

    # TC O(n)
    # SC O(n)