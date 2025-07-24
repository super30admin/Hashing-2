# Time Complexity: O(n*m) n - iterating through the given array | m- iterating through Dictionary
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: Figuring out the edge case

class Solution:
    """
    input - array, k
    output - count
    """
    def subarraySum(self, nums: list[int], k: int) -> int:
        sumDict = {}
        sumDict[0] = 1
        rSum = 0
        subCnt = 0
        
        for num in nums: # 0
            rSum += num # 1
        
            calc = (rSum - k) # 1-0 = 1
            if calc in sumDict:
                subCnt += sumDict[calc] # cnt = 0

            sumDict[rSum] = sumDict.get(rSum, 0) + 1;

        return subCnt