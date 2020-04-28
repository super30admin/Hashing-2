class Solution:
    def findMaxLength(self, nums):
        maxlen = 0
        sum = 0
        counts = {0: -1}
        for i, j in zip(nums, range(len(nums) + 1)):
            if i == 0:
                sum += 1
            else:
                sum -= 1
            if sum in counts:
                maxlen = max(maxlen, j - counts[sum])
            else:
                counts[sum] = j

        return maxlen


s = Solution()
print(s.findMaxLength([1, 1, 0, 0, 1, 0]))
