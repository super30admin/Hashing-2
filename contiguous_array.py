class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = collections.defaultdict(int)
        res[0] = -1
        count = 0
        maxLen = 0

        for i, v in enumerate(nums):
            if v == 0:
                count -= 1
            else:
                count += 1
            if count in res:
                maxLen = max(maxLen, i - res[count])
            else:
                res[count] = i
        return maxLen






