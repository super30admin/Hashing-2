# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No

class Solution(object):
    def subarraySum(self, nums, k):
        Hashmap={0:1}
        subarr_count=0
        rsum=0
        for i in nums:
            rsum+=i
            subarr_count+=Hashmap.get(rsum-k,0)
            Hashmap[rsum]=1+Hashmap.get(rsum,0)
        return (subarr_count)