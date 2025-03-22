# using hashing to find the max length of contiguous array.
# TC: O(N) we iterate through an array
# SC: O(N) storing running sum into dictionary


from typing import List


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        runningSumDict = {0: -1}  # Stores first occurrence index
        max_length = 0
        runningSum = 0

        for i in range(len(nums)):
            # Convert 0 to -1 to balance the sum
            runningSum += 1 if nums[i] == 1 else -1

            if runningSum in runningSumDict:
                max_length = max(max_length, i - runningSumDict[runningSum])
            else:
                runningSumDict[runningSum] = i  # Store first occurrence

        return max_length


sol = Solution()
array = [0, 1, 0, 1, 1, 0, 1, 1]
print(sol.findMaxLength(array))
