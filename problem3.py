class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        d=collections.defaultdict(int)
        d[0] = -1
        s=0
        res=0
        for i in range(0, len(nums)):
            if nums[i]==0:
                s-=1
            else:
                s+=1
            if s in d:
                res=max(res,i- d[s])
            else: d[s]=i
        return res