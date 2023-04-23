#Time Complexity:O(n)
#Space Complexity:O(n)
class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        count=0
        rSum=0
        sumHash={0:1}
        for i in range(len(nums)):
            rSum=rSum+nums[i]
            if rSum-k in sumHash:
                count=count+sumHash.get(rSum-k)
            if rSum in sumHash:
                sumHash[rSum]=sumHash.get(rSum)+1
            else:
                sumHash[rSum]=1
        return count