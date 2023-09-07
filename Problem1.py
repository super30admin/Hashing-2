'''
1. We maintain a presum array that keeps track of sum until index i.
2. Then we maintain a dictionary that checks if there the difference in presum until an index is same as that until another index which means the sum of elements between those two is equal to k. 
3. When we encounter another such instance that has difference of presum and k as the key in the dictionary it means this subarray will have the sum as k. We increment number with the occurances of that difference.

TC: O(n)
SC: O(n)
'''
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        res = 0
        presum = 0
        presum_counts = {0:1}

        for i in nums:
            presum += i

            if (presum-k) in presum_counts:
                res += presum_counts[presum-k]
            if presum not in presum_counts:
                presum_counts[presum] = 1
            else:
                presum_counts[presum] += 1
        return res