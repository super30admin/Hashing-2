# https://leetcode.com/problems/contiguous-array/

# Finding the contiguous array using the running sum approach. Here creating the hashmap which contains first index of each running sum. Whenever same running sum happens subtract the current index from the previously happened running sum index to get the number of elements.
# Time Complexity- O(n) Space Complexity- O(n)

# contiguous array means equal number of 0 and 1.  
# A subarray with equal 0s and 1s will have a running sum of 0. 
# we can access the key and get the value in hashmap. So, we need to check whether the running sum happened or not. so it acts like a key and index as a value

class Solution:
    def findMaxLength(self, nums: list[int]) -> int:
        n = len(nums)
        # initialise the hashmap
        map = {0 : -1}
        # intialise the running total
        running_sum = 0
        # initialse the max length of the array
        max_len = 0
        # iterate over the list of nums
        for i in range(n):
            # num has the number of the particular index
            num = nums[i]
            # check the number
            if num == 0:
                # if it's 0 then decrement it
                running_sum -= 1
            else:
                # if it's 1 then increment it 
                running_sum += 1
            
            # if running_sum is already present in the map
            if running_sum in map:
                # it means there are equal number of 0's ad 1's between current and previous index(map[running_sum])
                # here we are doing subtraction between current last occurance.so for this last index we'll get by dictionary syntax because we are storing the index in the form of the value
                # so it's like 4-2 = 2
                max_len = max(max_len , i - map[running_sum])
            # if running sum is not present then update the index of the running sum 
            else:
                map[running_sum] = i
        #  return the max len
        return max_len



solution = Solution()
print(solution.findMaxLength([0,1]))
print(solution.findMaxLength([0,1,0,1,1,1,0,1]))

        

