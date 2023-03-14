# Time Complexity : O(n)
# SPace Complexity : O(n)

from typing import List
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        hashmap = {0: 1}  # initialize hashmap with count 0 and frequency 1
        sum_so_far = 0
        
        for num in nums:
            sum_so_far += num
            
            if sum_so_far - k in hashmap:
                count += hashmap[sum_so_far - k]
            
            if sum_so_far in hashmap:
                hashmap[sum_so_far] += 1
            else:
                hashmap[sum_so_far] = 1
                
        return count