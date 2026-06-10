## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        """
        Time Complexity: O(n)
        - We iterate through the 'nums' array exactly once.
        - Hash map (defaultdict) insertions and lookups take O(1) time on average.
        
        Space Complexity: O(n)
        - In the worst-case scenario (e.g., all positive numbers), every running sum is unique.
        - This means we could potentially store up to 'n' distinct prefix sums in 'rSumFreqMap'.
        """
        
        # 'result' tracks the total number of subarrays that sum to k.
        # 'rSum' tracks the running sum (prefix sum) as we iterate through the array.
        result = rSum = 0
        
        # Hash map to store the frequency of each running sum we've seen so far.
        rSumFreqMap = defaultdict(int)
        
        # Base case: Initialize the map with a prefix sum of 0 having a frequency of 1.
        # This is crucial for handling subarrays that sum to 'k' starting from the very first element (index 0).
        rSumFreqMap[0] = 1

        # Iterate through the array.
        for i, n in enumerate(nums):
            # 1. Update the current running sum.
            rSum += n
            
            # 2. Check for subarrays ending at the current index 'i' that sum to 'k'.
            # If the difference (rSum - k) exists in our map, it means there is a previous 
            # prefix sum that we can subtract from our current prefix sum to get exactly 'k'.
            x = rSum - k
            
            # If we've seen the prefix sum 'x' before, add its frequency to our result.
            if x in rSumFreqMap:
                result += rSumFreqMap.get(x)
            
            # 3. Add the current running sum to the map so future iterations can use it.
            rSumFreqMap[rSum] += 1
        
        return result