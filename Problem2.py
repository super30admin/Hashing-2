'''
1. We maintain a prefix sum array that has sum until that index.
2. When we encounter a 0 let us add -1 to the sum. If it is a 1 then add it.Now when we see the prefix sum array we can say there are equal number of 0s and 1s between any two indices if the corresponding entries in the array is same.
3. Find if we encountered same sum using a dictionary and get the maximum range.

TC: O(n)
SC: O(n)
'''

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        res = 0
        ps = 0
        prefix_sum_at_idx = {0: -1}
        for i, n in enumerate(nums):
            ps = ps+1 if n == 1 else ps-1
            if ps in prefix_sum_at_idx:
                print("res",i - prefix_sum_at_idx[ps])
                res = max(res, i - prefix_sum_at_idx[ps] )
            else:
                prefix_sum_at_idx[ps] = i
        return res