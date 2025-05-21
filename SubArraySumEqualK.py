# Explain your approach in **three sentences only** at top of your code
# 1) idea is to get running sum to eliminate the nested subarray . The concept is if we have a subarray with sum k then we can just subtract it from x (rsum upto that number) and check if y exisits
# 2) implement the above idea using hashmap handle edge case for subarray starting from 0 by maintaining the rsun and count 

from typing import List
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hashMap = {}
        hashMap[0] = 1
        rsum, res = 0,0
        for i in range(len(nums)):
            rsum+=nums[i]
            if (rsum - k) in hashMap:
                res+=hashMap.get(rsum-k)
            if rsum not in hashMap:
                hashMap[rsum] = 1
            else:
               hashMap[rsum] = hashMap.get(rsum) + 1
        return res


        