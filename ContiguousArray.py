# Explain your approach in **three sentences only** at top of your code
# 1) maintaine count where count+=1 if num = 1 or decrease by 1
# 2) use the running sum concept x-y=z . so if x and y are equal then z = 0 meaning the subarray sum is 0 (this happens only when count 1 and 0 are equal)
# 3 to get the length keep tract of i indexes where the same number occurs and get lenght by i-hashmap.get(rsum)

from typing import List
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hashMap = {}
        hashMap[0] = -1
        count, maxlen = 0, 0
        for i in range(len(nums)):
            if nums[i] == 0:
                count-=1
            else:
                count+=1
            if count not in hashMap:
                hashMap[count] = i
            else:
                maxlen = max(maxlen, i-hashMap.get(count))
        return maxlen





        