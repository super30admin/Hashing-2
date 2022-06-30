# Time Complexity = O(n)
# Space Complexity = O(n), because we are storing the running sum

class Solution:
    def findMaxLength(self, nums: list[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        
        lenDict = {}
        rSum = 0
        maxLen = 0
        lenDict.update({0: -1})         # For cases like [0, 1, ...]
        
        for i in range(len(nums)):
            elem = nums[i]
            
            # If element in list is 1, add 1 to rSum, if it is 0, subtract 1 from rSum
            if elem == 1:
                rSum += 1
            else:
                rSum -= 1
            
            # Add the value(i.e index) for rSum
            if rSum not in lenDict:
                lenDict[rSum] = i
            # Check if the difference between current index and stored index in hashmap for that particular rSum value is greater than the max length. If yes, update max length
            else:
                temp = i - lenDict[rSum]
                maxLen = max(maxLen, temp)
                
        return maxLen