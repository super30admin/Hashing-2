# Method 1 - Hashmap
# Time Complexity - O(n), where n is the length of s
# Space Complexity - O(n) 
# We use a running sum to emulate the generation of all possible contiguous arrays.
# In running sum, if 0 occurs, subtract by 1, if 1 occurs, add by 1.
# If running sum is in the hashmap, check if current-hashmap[running sum] is bigger than max, if yes, udpate it. No, need to 
# If running sum isn't in the hashmap, make a new entry with the index as value.
# Key Adjustment - hashmap[0]=-1


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        running_sum=0
        running_sum_map={0:-1} #if the contiguous subarray starts from 0th index, it will be missed, so set first occurency of 0 to be at -1
        max_len=0

        for i in range(len(nums)):
            if nums[i]==0:
                running_sum-=1
            else:
                running_sum+=1
            if running_sum in running_sum_map:
                max_len=max(max_len,i-running_sum_map[running_sum]) #if start and end asked - whenever max_len changes, you can update start and end adn print it out in the end
            else:
                running_sum_map[running_sum]=i
        return max_len