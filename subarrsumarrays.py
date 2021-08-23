# Time Complexity : O(N)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : I did not get the logic right



class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        temp = k
        count = 0
        for i in range(len(nums)):
            if nums[i] == k:
                count += 1
            else:
                if temp == 0:
                    count += 1
                    temp = k
                    i = i - 1
                else:
                    if (temp - nums[i]) >= 0:
                        temp -= nums[i]
        return count