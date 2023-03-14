#Time Complexity : O(n)
#Space Complexity : O(n)

from typing import List
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        count = 0
        max_length = 0
        hashmap = {0: -1}  # initialize hashmap with 0 count and index -1
        
        for i in range(len(nums)):
            if nums[i] == 0:
                count -= 1
            else:
                count += 1
            
            if count in hashmap:
                max_length = max(max_length, i - hashmap[count])
            else:
                hashmap[count] = i
        
        return max_length
