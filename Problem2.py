class Solution(object):
    def findMaxLength(self, nums):
        """
        Time complexity - O(n), n --> length of nums
        Space complexity - O(n)
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0

        rSum, maxi = 0, 0  # Initialize running sum and maximum length
        rSumMap = {}  # Create a dictionary to store running sums and their corresponding indices
        # Initialize the dictionary with a running sum of 0 at index -1
        rSumMap[0] = -1

        for i in range(len(nums)):
            if nums[i] == 1:
                rSum += 1  # Increment running sum if the current number is 1
            else:
                rSum -= 1  # Decrement running sum if the current number is 0

            if rSum in rSumMap:
                # If the current running sum is already present in the dictionary,
                # calculate the length of the subarray with equal number of 0s and 1s
                # by subtracting the previous index of the running sum from the current index
                maxi = max(maxi, i - rSumMap[rSum])
            else:
                # If the current running sum is not in the dictionary, add it with its current index
                rSumMap[rSum] = i

        return maxi
