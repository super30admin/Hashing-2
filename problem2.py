# contiguous-array
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        max_length = 0
        diff = 0
        diff_index_map = {0: -1}
        for i, val in enumerate(nums):
            diff += 1 if val == 1 else -1
            if diff in diff_index_map:
                length = i - diff_index_map[diff]
                if length > max_length:
                    max_length = length
            else:
                diff_index_map[diff] = i
        return max_length