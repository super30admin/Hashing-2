# Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
# Time Complexity :O(n), one pass through the array
# Space Complexity :O(n), hashmap stores up to n prefix sums
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :Yes, I was a bit confused on what to add in the map and what we have to return


# Your code here along with comments explaining your approach

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        n = len(nums)          # total number of elements in array
        map = {0: 1}           # { rsum : how many times seen },pre-load 0:1 as dummy
        rsum = 0               # running prefix sum
        result = 0             # total count of valid subarrays found

        for num in nums:                            # visit every element one by one
            rsum = rsum + num                       # add current element to running sum
            occurance = rsum - k                    # what prefix sum do we NEED to have seen before?
            if occurance in map:                    # if that prefix sum was seen before
                result = result + map[occurance]    # add how many times it was seen (each = one valid subarray)
            map[rsum] = map.get(rsum, 0) + 1        # record current rsum, increment its count by 1

        return result          # total subarrays whose sum equals k