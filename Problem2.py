class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        
        hash_map = {0:1}
        count=0
        rs = 0

        for i in range(len(nums)):
            rs = rs + nums[i]
            if  rs - k in hash_map:
                count += hash_map[rs - k]
                
            if rs not in hash_map:
                hash_map[rs] = 1
            else:
                hash_map[rs] += 1

        return count
                
