class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Intuition:
        # create a hashmap with key as running sum and idx as value
        # If we encounter 0 while iterating, decrement by 1 else increment by 1. We keep track of the idx of first occurrence of a running sum since we need the longest continuous sub-array length.

        refMap = {}  # SC: O(n) since hashmap size scales with input
        rSum = 0
        # put 0 as the rSum for -1 idx to handle first element edge case otherwise first element will never be considered in the max length
        refMap[0] = -1
        maxLen = 0

        for i in range(len(nums)):  # TC: O(n)
            if nums[i] == 1:
                rSum = rSum + 1
            else:
                rSum = rSum - 1

            # store rSum in map if first occurrence
            if rSum not in refMap:
                refMap[rSum] = i
            else:
                # calculate max of (current idx - first occurence) idx of a rSum
                maxLen = max(maxLen, i - refMap[rSum])
        return maxLen


obj = Solution()
print(obj.findMaxLength([1, 0, 1, 1, 0, 1, 0]))
