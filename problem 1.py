# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
# - Easy to forget the seed {0:1} (needed to count subarrays starting at index 0)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)                 # length of array (note: we don't actually use 'n'; safe to remove)
        first = {0: 1}                # maps prefix_sum -> how many times we've seen it so far
                                      # start with {0:1} so subarrays that begin at index 0 are counted
        rSum = 0                      # running (prefix) sum up to the current index
        result = 0                    # total number of subarrays whose sum == k

        for num in nums:              # scan each number once
            rSum += num               # update running sum
            y = rSum - k              # we want prior prefix sums equal to (current_sum - k)
            if y in first:            # if we've seen such a prefix sum before,
                result += first[y]    # then each occurrence makes one valid subarray ending here
            # record that we've now seen this rSum one more time
            first[rSum] = first.get(rSum, 0) + 1

        return result                 # final count of subarrays summing to k
