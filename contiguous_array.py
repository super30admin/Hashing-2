"""Using a prefix_array to store cummulative sum of all the values in the input array
until current index. Then store these running sum values in a hashmap with key as sum
and value as index. 

Time complexity: O(n)
Space complexity: O(n) """
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        n = len(nums)
        max_len = 0
        prefix_array = [0] * (n+1)
        for i in range(1, n+1):
            prefix_array[i] =  prefix_array[i-1] + (1 if nums[i-1] == 1 else -1)
        
        sum_map = {}
        for i,sum in enumerate(prefix_array):
            if sum not in sum_map:
                sum_map[sum] = i
            else:
                current_len = i - sum_map[sum]
                max_len = max(current_len, max_len)
        return max_len