class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxxer = 0
        rsum = 0
        map = {}
        map[0] = -1
        for i in range(len(nums)):
            if nums[i] == 0:
                rsum -= 1
            else:
                rsum += 1
            if map.has_key(rsum):
                maxxer = max(maxxer, (i - map[rsum]))
            else:
                map[rsum] = i
        return maxxer
        