class SubArraySum(object):
    '''
    Solution
    1. Calculate running sum at each index, check if runningSum - k is already present in the dictionary containing
     count of occurences of runningSum.
    2. If it is present with a particular count, it means that subarray of sum k occurred and update the final count by
     the count mapped to that runningSum.
    3. Finally, return the updated finalCount.

    --- Passed all testcases on Leetcode successfully
    '''
    
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # O(n) Time Complexity | O(n) Space Complexity
        if (nums == None or len(nums) <= 0):
            return 0

        count = 0
        countOccurences = {}
        countOccurences[0] = 1
        runningSum = 0

        for i in range(len(nums)):
            runningSum += nums[i]
            if (runningSum - k in countOccurences):
                count += countOccurences[runningSum - k]

            if (runningSum not in countOccurences):
                countOccurences[runningSum] = 1
            else:
                countOccurences[runningSum] += 1

        return count