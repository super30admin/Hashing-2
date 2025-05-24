# Time Complexity: O(n)
# Space Complexity: O(n)
from typing import List

def subarraySum(nums: List[int], k: int) -> int:
    prefix_sum_count = {0: 1}
    prefix = 0
    result = 0
    
    for num in nums:
        prefix += num
        remaining = prefix - k
        result += prefix_sum_count.get(remaining, 0)
        prefix_sum_count[prefix] = prefix_sum_count.get(prefix, 0) + 1
    
    return result
