# Problem 1: Subarray Sum Equals K (https://leetcode.com/problems/subarray-sum-equals-k/)
# Time Complexity: O(N) where N is the number of elements in the input array.
# Space Complexity: O(N) for the hashmap.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No
# Your code here along with comments explaining your approach
# 1. Use a hashmap to store the frequency of prefix sums.
# 2. For each element, calculate the running sum and check if (running sum - k) exists in the hashmap.
# 3. If it exists, it means there is a subarray that sums to k ending at the current index.
# 4. Update the count of such subarrays and also update the frequency of the current running sum in the hashmap.

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if nums == None or len(nums) ==0:
            return -1
        
        rsum = 0
        count = 0
        freq_map = {0: 1}

        for n in nums:
            rsum += n
            if (rsum - k) in freq_map:
                count += freq_map[rsum - k]
            freq_map[rsum] = freq_map.get(rsum, 0) + 1

        return count