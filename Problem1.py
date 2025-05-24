class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        max_element = 0
        hash_map = {0:-1}
        rs = 0
        
        for cur in range(len(nums)):
            rs = rs-1 if nums[cur] == 0 else rs+1
            if rs in hash_map:
                subarray_len = cur - hash_map[rs]
                max_element = max(subarray_len,max_element)
            else:
                hash_map[rs] = cur
        
        return max_element


        