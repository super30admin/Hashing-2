# Time Complexity : O(n)
# Space Complexity :O(n)
# Leet Code: Yes
# Used the approach of running sum

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:

        if len(nums) == 0:
            return 0

        count = 0
        # handling edge case where running sum is 0 found at index -1, frequency 1
        hashmap = {0: 1}
        n = len(nums)
        s = 0
        for i in range(n):
            s += nums[i]
            if (s - k) in hashmap:
                count += hashmap[s-k]
            
            # if running sum not present in the hashmap
            # add it along with its frequency
            if s not in hashmap:
                hashmap[s] = 1
            else:
                hashmap[s] += 1


            

        return count

        