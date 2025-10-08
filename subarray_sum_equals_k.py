from collections import defaultdict
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        count = defaultdict(int)
        count[0] = 1 
        total = 0

        rsum = 0
        for num in nums:
            rsum += num
            diff = rsum - k
            if diff in count:
                total += count[diff]
            count[rsum] += 1

        return total
