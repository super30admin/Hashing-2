"""
I loop thru the array and go on calculating the sum. I add 1 to sum for every occurence of '1' and '-1' for every occurence
of '0'. After each sum calculation, I add the sum and its position to hashmap, if it's absent. If at later stage in the loop
if I find the sum to equal to sum found before, then it tells us that all elements in between had equal occurence of Os and 1s.

I keep track of the max length possible and return the same


Time Complexity : O(n) since we are looping thru the array once
Space Complexity : O(n) since we are creating a hashmap of length 'n'
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced
"""


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        sum = 0
        max_length = 0
        maps = defaultdict(int)
        maps[0] = - 1

        for i in range(len(nums)):
            if nums[i] == 0:
                sum += - 1
            elif nums[i] == 1:
                sum += 1

            if sum in maps:
                length = i - maps[sum]
                max_length = max(length,max_length)
            elif sum not in maps:
                maps[sum] = i

        return max_length