# Time complexity : O(n)
# Space complexity : O(n), since all values of running sum will be stored in the hash map
# Maintain a hashmap with key being running sum at every index and value being its frequency. 
#At every index, increment counter by the value of the residual in hash map 
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # Consider sum = 0 at index -1 to avoid edge cases
        hash_map = {0: 1}
        # Running sum
        rSum = 0; count = 0

        for i in range(len(nums)):
            rSum += nums[i]
            residual = rSum - k
            if residual in hash_map:
                count+=hash_map[residual]
            if rSum in hash_map:
                hash_map[rSum] += 1
            else:
                hash_map[rSum] = 1
        return count
