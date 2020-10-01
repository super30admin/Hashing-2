// Time Complexity :O(N)
// Space Complexity : O(N), N is no of chars in string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hm={}
        hm[0]=-1
        maxlen=0
        count=0
        for i in range(len(nums)):
            count += 1 if nums[i] == 1 else -1
            if count in hm:
                maxlen = max(maxlen, i-hm[count])
            else:
                hm[count]=i
        return maxlen
        