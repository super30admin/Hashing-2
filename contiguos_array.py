def findMaxLength(self, nums: List[int]) -> int: # Tc: O(n) SC: O(n)
        smap={0:-1}
        rsum=0
        maxlen=0

        for i in range(len(nums)):
            if nums[i] == 0:
                rsum-=1
            else:
                rsum +=1
            if rsum in smap:
                maxlen=max(maxlen, i-smap[rsum])
            else:
                smap[rsum]=i
        return maxlen