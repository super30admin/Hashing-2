# Time Complexity --> O(n)
# Space Complexity --> O(n)
# Approach --> Use Running sum and Hashing. Maintain a hashmap that stores rsum and the number of occurences. If rsum-k is already available in the hmap, then add the corresponding occurences count to the output. rsum is the sum of values in main array and k is the sum of values in a subarray. Similarly, we now have rsum-k as a subarray and just checking if that is already available.

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        rsum = 0
        hmap = {}
        hmap[0] = 1
        op = 0

        for i in range(len(nums)):
            rsum = rsum + nums[i]

            if rsum-k in hmap:
                op = op + hmap[rsum-k]

            if rsum not in hmap:
                hmap[rsum] = 1
            else:
                hmap[rsum] = hmap[rsum]+1
        return op
