# T.c-> O(n)
# S.c-> O(n)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        total=0
        rSum=0
        hmap= {}
        hmap[0]= 1

        for i in range(len(nums)):
            rSum += nums[i]

            if rSum-k in hmap.keys():
                total+= hmap[rSum-k]
            if rSum in hmap.keys():
                hmap[rSum]+=1
            else:
                hmap[rSum]=1
        return total
