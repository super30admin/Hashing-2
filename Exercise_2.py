# Time Complexity  : O(n) where n = len(nums)
# Space Complexity : O(n) for the hashmap
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No issues


from typing import List
from collections import defaultdict

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        
        freq = defaultdict(int)
        freq[0] = -1  # sum 0 at index -1 (before array start)
        max_len = 0
        curr_sum = 0

        for i in range(len(nums)):
            if nums[i] == 1:
                curr_sum += 1
            else:
                curr_sum -= 1
            
            # length is current index minus first occurrence
            if curr_sum in freq:
                max_len = max(i - freq[curr_sum], max_len)
            else:
                freq[curr_sum] = i # record first time we see this sum

        return max_len
    

if __name__ == "__main__":
    sol = Solution()
    # Example 1
    print(sol.findMaxLength([0, 1]))      # expected 2
    # Example 2
    print(sol.findMaxLength([0, 1, 0]))   # expected 2
    # Example 3
    print(sol.findMaxLength([0, 1, 1, 1, 1, 1, 0, 0, 0]))# expected 6