## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES


# Your code here along with comments explaining your approach:
# - Use a prefix sum technique with a hashmap to track running sum frequencies
# - For each position, check if there was a previous running sum that, when subtracted
#       from the current running sum, equals k

def subarraySum(nums, k):
    # Counter for the number of valid subarrays found
    res = 0
    # Running sum as we iterate through the array
    r_sum = 0

    # Dictionary to store frequency of running sums
    # Key: running sum value, Value: frequency of occurrence
    r_sum_freq = {}

    # Initialize with 0:1 to handle cases where the entire subarray from beginning sums to k
    r_sum_freq[0] = 1

    for n in nums:
        # Update running sum with current element
        r_sum += n
        # Calculate the complement needed (if it exists in our running sum history)
        # If current r_sum - complement = k, then the subarray between those points sums to k
        cmplmnt = k - r_sum
        
        # If we've seen this complement before, it means there are subarrays ending at current position with sum k
        if cmplmnt in r_sum_freq:
            # Add the frequency of the complement to our result
            res += r_sum_freq[cmplmnt]

        # Update the frequency of the current running sum
        if r_sum in r_sum_freq:
            r_sum_freq[r_sum] += 1
            
        else:
            r_sum_freq[r_sum] = 1
    
    return res


nums = [1,1,1]
k = 2
subarraySum(nums,k)

