#Time Complexity : O(n)
#Space Complexity : O(n) 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        prefix_sum = 0
        #key will be prefix sum, value will be earliest occurence index
        d = {0:-1}
        max = 0
        for i in range(len(nums)):
            if nums[i] == 1:
                prefix_sum += 1
            if nums[i] == 0:
                prefix_sum -= 1
            
            if prefix_sum in d:
                if max < i - d[prefix_sum]:
                    max = (i - d[prefix_sum])
            if prefix_sum not in d:
                d[prefix_sum] = i
        
        return max
