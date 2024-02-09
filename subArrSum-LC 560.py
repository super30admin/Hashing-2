# Time Complexity = O(n)
# Space Compelxity = O(n)

class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        if nums == None or len(nums) == 0:
            return 0
        
        countDict = {}
        count = 0
        rSum = 0
        countDict.update({0: 1})            # For base case array: [3,4]
        
        for i in range(len(nums)):
            elem = nums[i]
            rSum += elem
            
            # Check if the difference is already in dict. If so, increase the corresponding subarrays counter by the value stored at that difference, in dictionary
            if (rSum - k) in countDict:
                count += countDict[rSum - k]
            
            # Add in dictionary, if not present
            if rSum not in countDict:
                countDict[rSum] = 1
            # Increase the corresponding rSum count value by 1
            else:
                countDict[rSum] += 1
                
        return count
