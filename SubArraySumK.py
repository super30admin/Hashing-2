class Solution:
    """
    Time complexity - O(n) n - length of nums.
    Space complexity - O(n) worst case space complexity
    """
    def subarraySum(self, nums: list[int], k: int) -> int:
        # keeps count of how many times a sum is possible.
        sum_map = dict()
        # sum 0 is possible by not considering any subarray
        sum_map[0] = 1
        total = 0
        count = 0
        for num in nums:
            total += num
            if (total - k) in sum_map:
                count += sum_map[total - k]
            # updating sum_map to reflect the total calculated in current iter.
            if total in sum_map:
                sum_map[total] += 1
            else:
                sum_map[total] = 1
        return count
                