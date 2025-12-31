#Brute force is O(n3), so to optimize we need to use running sum/ prefix sum.
#The subarray between two same running sums is balanced.
#We need to find if the running sum has happened before so store the index.

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:

        hashMap = {0: -1}  #to store the earliest index but to handle edge cases where balanced subarray starts from 0th index
        #initialize prefix_sum 0 with index -1.

        prefix_sum = 0
        max_len = 0

        for i in range(len(nums)):
            if nums[i] == 0:
                prefix_sum -= 1
            else:
                prefix_sum += 1

            if prefix_sum in hashMap:#find the first index of sum if it exists
                max_len = max(max_len, i - hashMap[prefix_sum])
            else:
                hashMap[prefix_sum] = i

        return max_len    
    
# Time and Space Complexity: O(N)
# We can't use defaultdict(int) here because then hashMap[prefix_sum] check fails, since any missing key returns 0. 
# And 0 is falsy, so you can’t tell the difference between:
# “prefix_sum not in map” should go to else
# “prefix_sum first occurred at index 0” should go to if, but index 0 is falsy. So you miss valid cases where the earliest index is 0.