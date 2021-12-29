class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        hashmap = {0:1}
        count = 0
        rsum = 0
        for i in range(len(nums)):
            rsum = rsum + nums[i]
            if hashmap.has_key(rsum - k):
                count += hashmap[rsum-k]
            hashmap[rsum] = 1 if not hashmap.has_key(rsum) else hashmap[rsum] + 1
        return count