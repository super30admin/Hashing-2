""" 
TimeComplexity: O(N)
SpaceComplexity: O(N)

Approach: 
Initially, we start off by having a dictionary with key being the prefix some value and the value being the count
we initialize this dictionary with zero equal to one because to handle the case of subarrays starting from the first element
we then iterate through all the numbers and keep incrementing the value of prefix. Then we check the difference of prefix-sum, and the K.
This difference value would essentially mean that there exists an element in the virtual prefix-sum array whose difference with the current prefix-sum value would give us the target value.
We then check if there exists an element already if it does, then we increase the result counter with the count of elements.
We then go on to add the newest prefix value to the dictionary.
"""

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:

        prefix_sum_dict = defaultdict(int)
        prefix_sum_dict[0] = 1
        prefix_sum = 0
        res = 0

        for num in nums:
            prefix_sum += num
            res += prefix_sum_dict[prefix_sum - k]
            prefix_sum_dict[prefix_sum] += 1

        return res
