class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        
        res = float('-inf')
        d = dict()

        # this is for the first balanced subaray with sum 0.
        d[0] = -1

        rSum = 0
        for i in range(len(nums)):
            if nums[i] == 1:
                rSum += 1
            else:
                rSum -= 1

            # if we have seen rSum in the map before, we know that
            # a balanced array exists between the curIdx and the idx
            # at which we have encountered the rSum before.
            # No need to update the map with our currentIdx as we would
            # end up losing the maximum subarray requirement.
            if rSum in d:
                res = max(i - d[rSum], res)
            else:
                # First occurance, add it to the map
                d[rSum] = i

        return max(0, res)

#TC : O(n)
#SC : O(n)