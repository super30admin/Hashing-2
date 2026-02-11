# Time Complexity : O(n)
# Space Complexity : O(n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Use runningSum to keep track of the sum so far.
# Check if runningSum - k was seen before — if yes, we’ve found a valid subarray.
# Finally, we count how many times each running sum appeared using a hashmap.

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        runningSum, count = 0, 0
        runningSumToFreq = {0: 1}

        for num in nums:
            runningSum += num

            if runningSum - k in runningSumToFreq:
                count += runningSumToFreq[runningSum - k]


            runningSumToFreq[runningSum] = runningSumToFreq.get(runningSum, 0) + 1

        return count

        