# Time Complexity: O(n*m) | n - iterating through the given array | m- iterating through Dictionary 
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: Figuring out the edge case

class Solution:
    def findMaxLength(self, nums: list[int]) -> int:
        if nums == None or len(nums) == 0:
            return -1
        
        rSum = 0
        max_len = 0
        sumDict = {}
        sumDict[0] = -1 # if we have an array of [1,0,1,0] then the logic ill return only 2 instead of 4 as longest sub_array. Hence this is necessary

        for i in range(len(nums)):
            s = nums[i]
            
            if s == 0:
                rSum -= 1
            else:
                rSum += 1

            if rSum not in sumDict:
                sumDict[rSum] = i
            else:
                if max_len < i - sumDict[rSum]:
                    max_len = i - sumDict[rSum]
                
        return max_len