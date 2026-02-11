'''
https://leetcode.com/problems/contiguous-array/description/

Time Complexity: O(n)
Space complexity: O(n)

TIP: brute force: n*n loop to generate subarrays -> and finding the longest canditate. starting from each index in the array.
How do you eliminate the n*n loop? use running sum to remove the iteration..
since its 0-indexed - you dont need to add an extra 1 to find the diff in the length. this is wrong - i - minIndex[currSum] + 1
'''
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        #when you encounter 0 -> add -1 to running sum - handles edge case, which says when we start the iteration, sum is initially 0 at index -1
        runningSum = []
        minIndex = {}
        minIndex[0] = -1 #handle edge case for first occurence of 0 sum.
        currSum = 0
        longestLength = 0
        for i, el in enumerate(nums):
            if el == 0:
                currSum -= 1
            else:
                currSum += 1

            # runningSum.append(currSum)
            if currSum not in minIndex:
                minIndex[currSum] = i
            else:
                longestLength = max(longestLength, i - minIndex[currSum] )
        
        return longestLength
