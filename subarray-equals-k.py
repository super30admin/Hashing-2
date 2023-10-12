# Intuition 1 : Brute force - O(n^2)
# Intuition 2: Using running sum and using hashmap to keep track of the subarrays

# TC: O(n)
# SC: O(n) bcz we are creating a hashmap; when n is number of elements in an array

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        refMap = {}
        totalCount = 0
        rSum = 0

        # set first element as 0 in the map to consider first element in subarray formation if it adds up to target
        refMap[0] = 1
        for i in range(len(nums)):
            rSum = rSum + nums[i]  # calculate running sum

            # X(i.e. rSum) = Y+Z( i.e. k)
            # thus Y = rSum - k
            # if Y and rSum in map, then add number of times the rSum has occurred in total count
            # if rSum itself is not in map, then add it to map with count 1. If it already exists, increment by 1

            if rSum - k in refMap:
                totalCount = totalCount + refMap[rSum-k]

            if rSum in refMap:
                refMap[rSum] += 1
            else:
                refMap[rSum] = 1

        return totalCount
