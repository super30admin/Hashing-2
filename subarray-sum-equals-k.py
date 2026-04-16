# time: O(n)
# space: O(n)
# iterate through nums, track curSum, increment count if curSum = k
# increment count if we've seen curSum -k, then any sum after this point would have started after curSum-k. track the count of each curSum, 
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        curSum = 0
        count = 0
        h = defaultdict(int)
        for num in nums:
            curSum += num
            if curSum == k:
                count+=1

            count += h[curSum - k]

            h[curSum]+=1

        return count 
