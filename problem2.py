"""
## Problem2 (https://leetcode.com/problems/contiguous-array/)

Time Complexity : O(n) where n is the number of elements in the nums
Space Complexity : O(n) space require to store the runningSum and its first occurance
                    n is the number of elements in the nums

Did this code successfully run on Leetcode : Yes

Your code here along with comments explaining your approach:
Running Sum will help to reduce the nested iterations i.e no need to calculate y in the equation x + y = z

1. Declare a variables maxLength and runningSum and initailized to 0. Also declare a hashMap initialized with dummy variables (0,-1) to handle the case of [0,1] or [1,0]
2. Loop through the nums; add 1 to the runningSum if num == 1 and subtract 1 from runningSum if num == 0:
3. Check if running sum is present is hashMap
    - If present, then calculate the length (As same runningSum indicates the balance subArray (y= 0; as x==z))
    - Else add runningSum and its first Occurance to the hashMap
4. At the end return maxLength

"""


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        maxLength = 0
        runningSum = 0

        hashMap = {}
        hashMap[0] = -1

        for i in range(len(nums)):
            if nums[i] == 0:
                runningSum -= 1
            elif nums[i] == 1:
                runningSum += 1

            if runningSum in hashMap:
                maxLength = max(maxLength, i - hashMap[runningSum])
            else:
                hashMap[runningSum] = i

        return maxLength
