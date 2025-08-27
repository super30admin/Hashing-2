def subarraySum(self, nums: List[int], k: int) -> int: # Tc: O(n) SC: O(n)
        smap={0:1}
        rsum=0
        result=0

        for num in nums:
            rsum+=num
            cmp=rsum-k
            if cmp in smap:
                result+=smap[cmp]
            smap[rsum]=smap.get(rsum,0)+1
        return result