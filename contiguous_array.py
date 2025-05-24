# Time Complexity: O(n)
# Space Complexity: O(n) 

from typing import List

def findMaxLength(nums: List[int]) -> int:
    prefix_sum_count = {0: -1}
    prefix = 0
    max_length = 0
    
    for i, num in enumerate(nums):
        prefix += 1 if num == 1 else -1
        if prefix in prefix_sum_count:
            max_length = max(max_length, i - prefix_sum_count[prefix])
        else:
            prefix_sum_count[prefix] = i
    
    return max_length
