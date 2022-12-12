T.C : O(n)
S.C : O(n)
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if not nums:
            return 0
        hmap = {}
        hmap[0] = -1
        csum = 0
        result = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                csum -=2
            else:
                csum += 2
            if csum not in hmap:
                hmap[csum] = i
            else:
                result = max(result,i-hmap[csum])
        return result
        
        
