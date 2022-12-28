# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No

class Solution(object):
    def findMaxLength(self, nums):
        result=0
        rsum=0
        Hashmap={0:-1}
        for (n,i) in enumerate(nums):
            if(i==0):
                rsum-=1
            else:
                rsum+=1
            result=max(result,n-Hashmap.get(rsum,n))
            
            Hashmap[rsum]=min(n,Hashmap.get(rsum,1000000))
        return(result)
