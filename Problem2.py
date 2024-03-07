# T.C:- O(n)
# S.C.- O(n)

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hmap = {}
        hmap[0] = -1 
        max_ele = 0
        rSum = 0
        
        for i in range(0, len(nums)):
            if nums[i] == 0:
                rSum -= 1
            else:
                rSum += 1

            if rSum in hmap:
                max_ele = max(max_ele, i - hmap.get(rSum))
            else:
                hmap[rSum] = i

        return max_ele
