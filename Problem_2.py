"""
Problem : 6

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        size=2*len(nums)+1
        arr=[-2]*size
        arr[len(nums)]=-1
        maxlen=0
        count=0

        for i in range(len(nums)):
            if nums[i]==0:
                count+=-1
            else:
                count+=1
            if arr[count+len(nums)]>=-1:
                maxlen=max(maxlen,i-arr[count+len(nums)])
            else:
                arr[count+len(nums)]=i
        return maxlen
            