#Time: O(n) Space: O(n)
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        d={0:-1}
        maxl=0
        c=0
        for i in range(len(nums)):
            if nums[i]==0:
                c-=1
            else:
                c+=1
            if c in d:
                maxl=max(maxl,i-d[c])
            else:
                d[c]=i
        return maxl
