# Time Complexity: O(n)
# Space Complexity: O(n)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: The understanding of the index mapping for the running sum and running sum - k was confusing but had to perform a dry run to understand again

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        if not nums:
            return 0

        count = 0
        curr_sum = 0
        sum_freq = {0:1}

        # We will use running sum to check whether a subarray at that point totals the target val
        for i in range(len(nums)):
            curr_sum += nums[i]

            # increment count of subarrays summing to equal k value based on past running sums
            # if curr_sum - k is already present in the hashmap, that means that a subarray exists
            # whose sum is equal to k
            if sum_freq.get(curr_sum-k, None) is not None:
                count += sum_freq[curr_sum - k]

            # check and store the freq of running sum 
            if sum_freq.get(curr_sum, None) is not None:
                sum_freq[curr_sum] = sum_freq[curr_sum] + 1
            else:
                sum_freq[curr_sum] = 1

        return count

            
