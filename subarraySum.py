"""
Approach: 
We are using running sum approach and a hashmap to solve this problem
we are initilizing the running sum to 0.
As we iterate through all the integers in the array and update the running sum accordingly.
now we calculate the compliment of running sum and required value
if compliment is already in the hashmap, then we increment the count value with the previous value of the compliment key
we add the running sum as key and incrementing its value by 1
in the end we return count which gives the total no. of subarrays which gives the count of k

Time Complexity: O(n)

Space Complexity: O(n)

Passed in Leetcode: Yes

Any difficulties: No

"""
from typing import List
from collections import defaultdict

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefixMap =defaultdict(int)
        rsum = 0
        prefixMap[0] = 1
        count = 0

        for num in nums:
            rsum += num
            compliment = rsum - k
            if (compliment) in prefixMap:
                count += prefixMap[compliment]
            prefixMap[rsum] += 1
        
        return count

sol = Solution()
nums = [1,2,3]
k = 3
print(sol.subarraySum(nums, k))