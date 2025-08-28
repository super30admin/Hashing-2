## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)

# Time Complexity : O(N)
# Space Complexity : O(N) -- Number of distinct sums. Eg: [1,1,1,1,1,1]
# Did this code successfully run on Leetcode : Tes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Brute force way would have been generating all the subarrays and then checking each of them if sum == target. But here we use concept
# of running sum that helps us to find sum between any two places in the array ie sum of subarray without the need to iterate over the 
# elements. At any given current running sum we check if (current running sum - target) already exists with what frequency. 
# If this already exists it means we have got the subarray with sum == target. Also frequency of the (current running sum - target) value
# would tell us the number of subarrays for that running sum. So for this we require a hash map where store 
# running sum as key and frequemcy occurences of the running sum as value. 

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # It is used to eliminate the nested loops required to generate all
        # the subarrays
        runSum = 0
        countCorrSubArr = 0

        # used to maintain the running sum and its frequency occurrences
        # To consider all subarrays starting with index=0, we need to add 
        # default that 0 sum has occurred
        runSumFreqMap = {0:1}

        for i in range(len(nums)):
            runSum += nums[i]

            if((runSum - k) in runSumFreqMap):
                # we got a subarray whose sum = k
                # number of times this (runSum - k) has occurred before
                # is the number of subarrays we would get between elements
                # between currSum and when runSum was = (runSum - k)
                countCorrSubArr += runSumFreqMap[runSum - k]

            if(runSum in runSumFreqMap):
                runSumFreqMap[runSum] += 1
            else:
                runSumFreqMap[runSum] = 1

        return countCorrSubArr
    
sol = Solution()
print(sol.subarraySum([1,1,1], 2))
print(sol.subarraySum([1,2,3], 3))
print(sol.subarraySum([3, 4, 7, 2, -3, 1, 4, 2, 0, 1], 7))