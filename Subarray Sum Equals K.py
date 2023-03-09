# Time Complexity :  O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        runningSum = 0
        count = 0
        hashMap = {0:1}
        for i in nums:
            runningSum += i
            if runningSum-k in hashMap:
                count += hashMap[runningSum-k]
            if runningSum not in hashMap:
                hashMap[runningSum] = 1
            else:
                hashMap[runningSum] += 1
        print(hashMap)
        return count
            