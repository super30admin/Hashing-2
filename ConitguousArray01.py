class ContiguousArray(object):
    '''
    Solution:
    1. Calculate running sum at each index by considering 0 to be -1 and update a HashMap containing all first
     occurrences (index at which it occurred) of a running sum.
    2. If running sum occurs again, then calculate its distance from the first occurence and compare it with max length
     that was present at that point of time.
    3.  Return the final maximum length obtained after the traversal.

    --- Passed all testcases successfully on Leetcode
    '''
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # O(n) Time Complexity | O(n) Space Complexity
        if (nums == None or len(nums) <= 0):
            return 0

        maxLength = 0
        firstOccurences = {}
        firstOccurences[0] = -1
        runningSum = 0

        for i, num in enumerate(nums):
            runningSum = runningSum - 1 if num == 0 else runningSum + 1
            if (runningSum not in firstOccurences):
                firstOccurences[runningSum] = i
            else:
                maxLength = max(maxLength, i - firstOccurences[runningSum])

        return maxLength