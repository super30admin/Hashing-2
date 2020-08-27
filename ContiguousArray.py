#Time Complexity : O(n))
#Space Complexity : O(n) for dictionary
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : Don't fully understand how one can derive the edge case. I understand why it works
#but coming up with it can be confusing

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        result = 0

        # we initialize our dict to be {0:-1} because of the initial edge case
        dictt = {0: -1}
        cumulativeSum = 0

        # loop through the list
        for i in range(len(nums)):
            # add or subtract depending on whether its 0 or 1
            if nums[i] == 0:
                cumulativeSum -= 1
            else:
                cumulativeSum += 1

            # have we seen this before? if so, we subtract the index stored in our dict to get the range
            if cumulativeSum in dictt:
                currentSubArrayLength = i - dictt[cumulativeSum]
                result = max(currentSubArrayLength, result)
            # otherwise, we register it in our hashmap for the first time and the index we saw that sum at
            else:
                dictt[cumulativeSum] = i

        return result