# Time Complexity : O(n^2)
# Space Complexity : O(1)
#  Did this code successfully run on Leetcode : No. 72 / 89 test cases due to time limit exceeded exception.
# Any problem you faced while coding this : Yes. Brute Force approach was possible but not optimal. 
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        for i in range(len(nums)):
            sum = 0
            for j in range(i,len(nums)):
                sum += nums[j]
                if(sum == k):
                    count += 1
        return count
