## Problem2 (https://leetcode.com/problems/contiguous-array/)

# Time Complexity : O(n) 
# Space Complexity : O(n) in the worst case
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach:
# The key insight is to convert 0s to -1s conceptually, making an equal number of 0s and 1s
# equivalent to a subarray with a sum of 0.
# 1. We use a running sum that increases by 1 for each 1 and decreases by 1 for each 0
# 2. If we encounter the same running sum again, it means the subarray between these positions
#    must have an equal number of 0s and 1s (net change of 0)
# 3. We track the earliest occurrence of each running sum to find the maximum length
# 4. Initialize r_sum_freq[0] = -1 to handle cases where balanced subarray starts from index 0

def findMaxLength(nums):
    # Running sum that treats 0 as -1 and 1 as 1
    r_sum = 0

    # Dictionary to store the earliest occurrence of each running sum
    # Key: running sum value, Value: index of the earliest occurranc eof the r_sum
    r_sum_freq = {}

    # Initialize with sum 0 occurring at index -1 (before array starts)
    # To handle edge case - if the longest length of the array starts at index 0
    r_sum_freq[0] = -1
    max_len = 0

    for i in range(len(nums)):
        # Increment running sum by -1 for 0 and +1 for 1
        if nums[i] == 0:
            r_sum -= 1
        else:
            r_sum += 1

        # If this running sum was seen before, we've found a balanced subarray
        if r_sum in r_sum_freq:
            max_len = max((i - r_sum_freq[r_sum]), max_len)
        else:
            # Store first occurrence of this running sum
            r_sum_freq[r_sum] = i
        
    return max_len
    
