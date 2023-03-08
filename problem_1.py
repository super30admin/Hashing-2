# Time Complexity - O(n)
# Space Complexity - O(n)


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        dictionary = {}
        dictionary[0] = 1
        count = 0
        
        rSum = 0 
        for i in range(len(nums)):
            rSum += nums[i]
            if (rSum-k) in dictionary:
                count += dictionary[rSum-k]
            if rSum in dictionary:
                 dictionary[rSum] += 1 
            else :
                dictionary[rSum] = 1 
        return count



