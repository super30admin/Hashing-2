"""
TC -> O(n)
SC -> O(n)

same logic as subarray equals k. Only change is k is set as 0 and prefix calculation is as follows
a. add 1 if nums[i]==1
b. sub 1 if nums[i]==0
check if count ==0, if yes update length variable
if not check in hashmap. If its present, update length as max(length, i-hmap[count]
"""
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hmap = {}
        maxlen = 0
        count = 0
        for i in range(len(nums)):
            if nums[i] == 1:
                count += 1
            else:
                count -= 1
            if count == 0:
                maxlen = i + 1
            elif count in hmap:
                maxlen = max(maxlen, i - hmap[count])

            hmap[count] = i
        return maxlen
