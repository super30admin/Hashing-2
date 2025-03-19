'''
Approach:
1. Maintain a prefix sum dictionary to keep track of the cumulative sum frequencies.
2. Iterate through the array while updating the current sum and checking if the difference (curSum - k) exists in the dictionary.
3. Increment the result count if a valid subarray sum is found, update the prefix sum dictionary accordingly.
'''

# Time Complexity: O(n) (Each element is processed once)
# Space Complexity: O(n) (Storing prefix sums in a dictionary)

from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefix = { 0 : 1}

        res = 0
        curSum = 0

        for num in nums:
            curSum += num
            diff = curSum - k 

            res += prefix.get(diff, 0)
            prefix[curSum] = 1 + prefix.get(curSum, 0)
        
        return res
