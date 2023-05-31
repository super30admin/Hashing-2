# Time Complexity : O(n)
# Space Complexity :O(n)
# Leet Code: Yes
# Used the approach of running sum

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:

        if len(nums) == 0:
            return 0
        
        maxL = 0
        s = 0
        hashmap = {0: -1} # handle edge cases running sum is 0 at index -1

        for i in range(len(nums)):
            if nums[i] == 1:
                s += nums[i]
            else:
                s -= 1
            
            # if running sum does not exist in the hashmap
            # then add the running sum with the first index of the running sum
            if s not in hashmap:
                hashmap[s] = i
            
            # if the running sum already exist
            # check the max length
            else:
                maxL = max(maxL, (i - hashmap[s]))
        
        return maxL