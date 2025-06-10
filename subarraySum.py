# // Time Complexity :O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# Do running sum , check if prev running sum equal to running sum -k for that we can use dict 





from collections import defaultdict

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        d=defaultdict(int)
        d[0]=1
        rsum=0
        ans=0
        for i in nums:
            rsum+=i
            if rsum-k in d:ans+=d[rsum-k]
            d[rsum]+=1
        return ans
