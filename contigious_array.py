# Time Complexity: O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No


# Your code here along with comments explaining your approach
# Instead of going through the sums of each sub-array which takes O(N^2) we can actually take a HashMap calculate the prefix_sum from the given array
# Using a prefix_sum and a hashmap to store the first occurence of each sum
# if same sum appears at index j, then the sub-array between i and current index j has a total sum "0" since we are looking for same count of 0 and 1
 

class Solution:
    def findMaxLength(self, nums: List[int]):
        max_length = 0
        prefix_sum = 0
        Number_Map = dict()

        for index, val in enumerate(nums):
            if val == 1:
                prefix_sum += 1
            else:
                prefix_sum -= 1
            if prefix_sum == 0:
                max_length = index + 1
            if prefix_sum in Number_Map:
                length = index - Number_Map[prefix_sum]
                if max_length < length:
                    max_length = length
            else:
                Number_Map[prefix_sum] = index

        return max_length