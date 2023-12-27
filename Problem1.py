"""
I loop thru the array and go on calculating the prefix sum. After every sum, I check if its difference from 'k' is present in
the hashmap. If it is present then the number of occurences will equal to the possible no. of substrings possible


Time Complexity : O(n) since we are looping thru the array once
Space Complexity : O(n) since we are creating a hashmap of length 'n'
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced
"""

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefix_sum = 0
        maps= defaultdict(int)
        maps[0] = 1
        res= 0

        for i in nums:
            prefix_sum += i
            diff = prefix_sum - k

            if maps[diff]:
                res += maps[diff]

            if maps[prefix_sum]:
                maps[prefix_sum] += 1

            if not maps[prefix_sum]:
                maps[prefix_sum] = 1

        return res