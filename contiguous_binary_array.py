# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hash={0:-1}
        m=0
        sum=0
        l=len(nums)

        for i in range(l):
            if(nums[i]==0):
                sum-=1
            else:
                sum+=1
            if(hash.get(sum,-2)!=-2):
                m=max(m,i-hash[sum])
            else:
                hash[sum]=hash.get(sum,-2)+2+i
                # hash[sum]=i
        return m