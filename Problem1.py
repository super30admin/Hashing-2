# Time Complexity O(N)
# Space Complexity: O(N)

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        #BF:
        # res = 0
        # for i in range(len(nums)):
        #     curr = nums[i]
        #     if curr == k:
        #         res += 1
        #     for j in range(i + 1, len(nums)):
        #         curr += nums[j]
        #         if curr == k:
        #             res += 1
        
        # return res

        freq = {0: 1}
        res = 0
        curr = 0
        for i in range(len(nums)):
            curr += nums[i]
            compliment = curr - k
            if compliment in freq:
                res += freq[compliment]
            freq[curr] = freq[curr] + 1 if curr in freq else 1 
        
        return res
