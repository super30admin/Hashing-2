class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # TC: O(n), SC: O(n)
        hashmap = {}
        hashmap[0] = 1
        runningSum = count = 0
        for i in range(0,len(nums)):
            runningSum += nums[i]
            if (runningSum-k) in hashmap:
                count += hashmap[runningSum-k]
            if runningSum not in hashmap:
                hashmap[runningSum] = 1
            else:
                 hashmap[runningSum] += 1
        return count