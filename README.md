# Hashing-2

Explain your approach in **three sentences only** at top of your code


## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :  no


# Solution: we keep a running sum in an hash_map (constant lookup), and if running sum - target is in hashmap, that mean we can calculate that number and we can count that
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # 3, 4, 7, 2, -3, 1, 4, 2, 0, 1
        # 3, 7, 14,16,13,14, 18,20,20,21
        # -4,-3,0,-5,-10,-8,-3,-5,-7,-6
        running_sum = 0
        hash_map = {0: 1}
        count = 0
        for index, num in enumerate(nums):
            running_sum += num
            if (running_sum-k) in hash_map:
                count += hash_map[running_sum-k]
            hash_map[running_sum] = hash_map.get(running_sum, 0) + 1
        return count

## Problem2 (https://leetcode.com/problems/contiguous-array/)
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :  no


# Solution: 
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        # create running sum
        running_sum = 0
        hash_map = {0: -1}
        max_dist = 0
        # add running sum in a dict, such that running_sum is the key, and the value is the index of the first time the sum came up. 
        # maintain a max counter that storers the longest subarray so far
        for index, num in enumerate(nums):
            if num is 1: 
                running_sum += 1
                if running_sum in hash_map:
                    curr_dist = index - hash_map[running_sum]
                    if curr_dist > max_dist:
                        max_dist = curr_dist
                else: 
                    hash_map[running_sum] = index
            else:
                running_sum -= 1
                if running_sum in hash_map:
                    curr_dist = index - hash_map[running_sum]
                    if curr_dist > max_dist:
                        max_dist = curr_dist
                else: 
                    hash_map[running_sum] = index
        return max_dist

## Problem3 (https://leetcode.com/problems/longest-palindrome)
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :  no


# Solution: 
class Solution:
    def longestPalindrome(self, s: str) -> int:
        # get frequency of each letter
        freq = {}
        for l in s:
            # get freq of l, if doesn't exist then get 0
            freq[l] = freq.get(l, 0) + 1
        
        length = 0
        odd_found = False

        for count in freq.values():
            if count % 2 == 0:
                length += count
            else:
                length += count - 1
                odd_found = True

        # One odd character can be placed in the center
        if odd_found:
            length += 1
        
        return length