#TC: O(n), SC: O(n)
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        nums = list(map(lambda x: -1 if x==0 else 1, nums))
        prev_spot = dict()
        prefix_sum, max_window = 0, 0
        prev_spot[0] = -1
        for i, num in enumerate(nums):
            prefix_sum+=num
            if prefix_sum in prev_spot: max_window = max(max_window, i-prev_spot[prefix_sum])
            else: prev_spot[prefix_sum] = i

        return max_window