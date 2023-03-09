# Time Complexity :  O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hashmap = {0:-1}
        runningSum = 0
        maxSubArr = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                runningSum -= 1
            else:
                runningSum += 1
            if runningSum not in hashmap:
                hashmap[runningSum] = i
            else:
                maxSubArr = max(maxSubArr,i-hashmap[runningSum])
        return maxSubArr

            