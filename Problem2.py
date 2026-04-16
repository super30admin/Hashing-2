# Time Complexity --> O(n)
# Space Complexity --> O(n)
# Approach --> Use Running Sum and Hashing. When we encounter 0, reduce the rsum by 1 else increase by 1. Whenever the rsum is the same, the difference between indices of its first occurence and last occurence is the max possible contiguous subarray. To make sure the first index of the array can also be a part of subarray, create a dummy rsum of 0 at index -1. 
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        rsum = 0
        hmap = {}
        hmap[0]=-1
        op = 0

        for i in range(len(nums)):
            if nums[i]==0:
                rsum = rsum - 1
            else:
                rsum = rsum + 1

            if rsum not in hmap:
                hmap[rsum] = i
            else:
                op = max(op, i-hmap[rsum])
        
        return op

