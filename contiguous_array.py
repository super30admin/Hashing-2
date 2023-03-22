# Time Complexity : O(n) as we are iterating through the string
# Space Complexity : O(n) as we are using a hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""In this code we are using a hashmap to store the running sum and the index at which a 
particular sum was encountered the first time. Then we check if the difference between the 
current index and the index at which the running sum was encountered first is greater than 
the max length of the subarray. If it is, we update the max length."""

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums == None:
            return 0
        hashmap = {0:-1}
        max = 0
        rsum = 0

        for i in range(len(nums)):
            if nums[i] == 0:
                rsum -= 1
            else:
                rsum += 1
            
            if hashmap.get(rsum) == None:
                hashmap[rsum] = i
            elif i - hashmap[rsum] > max:
                max = i - hashmap[rsum]

        return max