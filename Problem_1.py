# https://leetcode.com/problems/subarray-sum-equals-k/description/

# Time complexity: O(n) 
# Space complexity: O(n)
# Explanation: Uses a hashmap to maintain the sum at every index on the array (prefix sum);
# every time we see a number repeat that means there is a subarray whose sum equals k betweem some index and current index

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hashmap = {}
        count, total = 0, 0
        hashmap[0] = 1
        for n in nums:
            total += n
            diff = total - k
            if diff in hashmap:
                count += hashmap[diff]
            hashmap[total] = hashmap.get(total, 0) + 1
        
        return count
