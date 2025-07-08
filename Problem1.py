# Time Complexity:
# O(n)

# Space Complexity:
# O(n)
class Solution(object):
    def subarraySum(self, nums, k):
        rsum, count=0, 0
        hmap={0 : 1}
        for i in range (len(nums)):
            rsum=rsum+ nums[i]
            if (rsum-k) in hmap:
                count=count+hmap[rsum-k]
            hmap[rsum]=hmap.get(rsum,0)+1
        return count
        