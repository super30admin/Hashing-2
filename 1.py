#Time: O(N) and Space: O(N)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        if n < 2:
            return 1 if nums[0] == k else 0
        
        count = 0
        cumulative_sum = 0
        sum_count = {0: 1} 
        
        for num in nums:
            cumulative_sum += num
            if cumulative_sum - k in sum_count:
                count += sum_count[cumulative_sum - k]
            sum_count[cumulative_sum] = sum_count.get(cumulative_sum, 0) + 1
        
        return count
