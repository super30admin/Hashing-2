class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        dic = collections.defaultdict(int)
        dic[0] = 1
        acc, count = 0, 0
        for num in nums:      
            acc += num
            if acc - k in dic:
                count += dic[acc - k]
                
            dic[acc] += 1
        return count