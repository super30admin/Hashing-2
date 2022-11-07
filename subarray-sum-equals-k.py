class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count, rsum, rsum_freq = 0, 0, collections.defaultdict(int)
        rsum_freq[0] = 1
        for num in nums:
            rsum+=num
            if rsum-k in rsum_freq:
                count+=rsum_freq[rsum-k]
            rsum_freq[rsum]+=1
        return count