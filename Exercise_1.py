from typing import List
from collections import defaultdict

class Solution:

    def subarraySum(self, nums: List[int], k: int) -> int:
        
        freq = defaultdict(int)
        count = 0
        curr_sum = 0
        freq[0] = 1  # one way to have sum=0 before starting

        for i in nums:
            curr_sum += i
            # if curr_sum - k was seen before, add how many times
            count += freq[curr_sum - k]
             # record this curr_sum for future subarrays
            freq[curr_sum] += 1

        return count



if __name__ == "__main__":
    sol = Solution()
    
   # Example 1
    print(sol.subarraySum([1,1,1], 2))    # expected 2
    # Example 2
    print(sol.subarraySum([1,2,3], 3))    # expected 2
    # Additional tests
    print(sol.subarraySum([1,2,1,2,1], 3))  # expected 4 ([1,2], [2,1], [1,2], [2,1])
    print(sol.subarraySum([0,0,0], 0))      # expected 6