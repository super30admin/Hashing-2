# TC : O(n)
# SC : O(n)

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        running_sum = 0
        sub_array_count = 0
        seen_at = { 0 : 1 } # Sum 0 is seen one time 
        # We are storing sum and the number of time we have seen it
        # As the question was to find total number of sub arrays - 
        # Store the occurance 
        # if the question was related to longest sub array with Target Sum then store the index for the running sum
        for num in nums:
            running_sum+= num
            if running_sum - k in seen_at:
                sub_array_count += seen_at[running_sum - k]
            if running_sum in seen_at:
                seen_at[running_sum] += 1
            else:
                seen_at[running_sum] = 1
        return sub_array_count
