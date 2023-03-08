# Time Complexity - O(n)
# Space Complexity - O(n)


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        dictionary = {}
        rSum = 0
        result = 0
        dictionary[0] = -1
        for i in range(len(nums)):
            if (nums[i] == 0):
                rSum -= 1 
            else :
                rSum += 1 
           

            if rSum in dictionary:
                result = max(result,(i-dictionary[rSum]))
            else :
                 dictionary[rSum] = i 
        return result



