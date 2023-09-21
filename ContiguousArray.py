# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Approach:
# We use the running sum technique & store the rsum and index in a dictionary (key = rSum, value = index).
# We set max to 0 and use a dummy sum as 0 at index -1 to handle  the edge case. [0,1] or [0,1]
# We add -1 to rSum if the number is 0 else add 1 to it. Then we check if the rSum is present in the dictionary.
# If it is not present we add the rSum and the respective index to the dictionary. else, we calculate
# the max between current max and  subtracting the current index and dictionary's rSum value  .
# Return the max in the end

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0

        res = dict()
        Max = 0
        rsum = 0
        res[rsum] = -1

        for i in range(len(nums)):
            if nums[i] == 0:
                rsum -= 1
            else:
                rsum += 1

            if rsum not in res.keys():
                res[rsum] = i

            else:
                Max = max(Max, i - res[rsum])

        return Max

