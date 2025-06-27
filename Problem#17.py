'''
560. Subarray Sum Equals K
'''

# Time Complexity : O(n ^ 2) for brute force, O(n) for optimized solution using HashMap
# Space Complexity : O(n) for optimized solution using HashMap
# Did this code successfully run on Leetcode : Yes, it passed all test cases.
# Any problem you faced while coding this : Yes, keeping track of the count of subarrays with sum equal to k using a HashMap was a bit tricky, have to ensure that we correctly update the count based on previous sums. will go through the logic again to ensure clarity.

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # Brute Force
        # Time Complexity: O(n^2)
        # Space Complexity: O(1)
        # count = 0
        # for i in range(len(nums)):
        #     total = 0
        #     for j in range(i, len(nums)):
        #         total += nums[j]
        #         if total == k:
        #             count += 1
        # return count
    
        # Optimized using HashMap
        # Time Complexity: O(n)
        # Space Complexity: O(n)
        count = 0 # humne count variable ko 0 se initialize kiya hai kyunki humne abhi tak koi bhi subarray nahi dekha hai jiski sum k ke barabar ho (we kept count variable initialized to 0 because we haven't seen any subarray with sum equal to k yet)
        total = 0 # total variable ko 0 se initialize kiya hai kyunki humne abhi tak koi bhi element nahi dekha hai (we kept total variable initialized to 0 because we haven't seen any element yet)
        hashmap = {0: 1}  # Initialize with 0 sum having one occurrence # humne ye hashmap banaya hai jisme 0 sum ki ek occurrence hai, kyunki agar total k ke barabar ho jaye to hum count ko increase kar sakte hain (we created this hashmap with one occurrence of 0 sum because if total becomes equal to k, we can increase the count)
        # Iterate through the array
        for num in nums: # humne nums array ke har element par num variable ko iterate kiya hai (we iterated through each element of the nums array)
            total += num # total variable mein current element ko add kiya hai (we added the current element to the total variable)
            # If (total - k) is in hashmap, add its value to count
            if (total - k) in hashmap: # agar (total - k) hashmap mein hai to hum uski value ko count mein add karte hain (if (total - k) is in hashmap, we add its value to count)
                count += hashmap[total - k] # humne count ko increase kiya hai kyunki humne ek aur subarray dekha hai jiska sum k ke barabar hai (we increased count because we found another subarray whose sum is equal to k)
            # Update hashmap with the current total
            hashmap[total] = hashmap.get(total, 0) + 1 # humne hashmap mein current total ko update kiya hai, agar total pehle se hai to uski value ko 1 se increase kiya hai, warna 1 set kiya hai (we updated the hashmap with the current total, if total is already present, we increased its value by 1, otherwise set it to 1)
        return count # humne count ko return kiya hai jo ki subarrays ka count hai jinka sum k ke barabar hai (we returned count which is the count of subarrays whose sum is equal to k)
    
# Example usage:
# solution = Solution()
# print(solution.subarraySum([1, 1, 1], 2))
# Output: 2 (subarrays [1, 1] and [1, 1] are the two subarrays with sum equal to 2)

# Dry Run:
# nums = [1, 1, 1], k = 2
# Initial hashmap: {0: 1}
# Iteration 1: num = 1
# total = 1, hashmap = {0: 1, 1: 1}
# (total - k) = -1 not in hashmap, count remains 0
# Iteration 2: num = 1
# total = 2, hashmap = {0: 1, 1: 1, 2: 1}
# (total - k) = 0 in hashmap, count += 1 (count = 1)
# Iteration 3: num = 1
# total = 3, hashmap = {0: 1, 1: 1, 2: 1, 3: 1}
# (total - k) = 1 in hashmap, count += 1 (count = 2)
# Final count = 2
# Return 2
# The function correctly counts the number of subarrays whose sum equals k. 