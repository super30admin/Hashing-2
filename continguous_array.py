"""
Brute Force, create all possible sub arrays, and see if it is balanced, if it is, then calculate the max length of the balanced and return it. TC - O(N^3).
with subarrays - sliding window, Hashing, two pointers, However, we cant use any of them here.
Approach discussed in Editorial, use -1 to keep track of zeroes, This time in the HashMap we store the count and the index. To help calculate the max length of the array. TC - O(N), SC - O(N)
"""
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        count_map = {}
        #Add [0,-1] to consider a count of zero at index -1. (Intializing for calculating the difference)
        count_map[0] = -1
        count = 0
        max_len = 0
        for i in range(len(nums)):
            if nums[i]:
                count += 1
            else:
                count += -1
            if count in count_map:
                #We calculate the diff of index to the length of subarray and then use max to track
                max_len = max(max_len, i-count_map[count])
            else:
                count_map[count] = i
        return max_len