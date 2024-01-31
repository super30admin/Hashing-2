'''
Time Complexity - O(n), we iterate over the array
Space Complexity - O(n), we are storing the running Sum in the hashMap

This code works on leetcode
'''
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        total_sum = 0
        sum_dict = {0: 1} # Initialize a dictionary with a key of 0 and a value of 1

        for num in nums:
            total_sum += num
            complement = total_sum - k
            if complement in sum_dict: # if we find the complement then it means that we have found a subarray with sum k and we are increasing the count
                count += sum_dict[complement]
            if total_sum in sum_dict: #if the sum is present in the hashMap then just increment the count
                sum_dict[total_sum] += 1
            else:
                sum_dict[total_sum] = 1 #else just add a new entry in the hashMap.

        return count