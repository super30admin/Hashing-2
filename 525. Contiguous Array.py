# Time: O(n) to go through all the elements of the array
# space: O(n) worst case when all the running sums are unique

# Create a hashmap that maintains the unique running sum with the index that they occured on
# Calculate running sum as +1 if the num is 1 else -1
# If running sum is already there in the map calculate the distance of the balanced sub array and check if it's greater that the previos max
# If running sum is not present simply add it with the index that it was encountered.

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        # to catch the edge case when the sub array starts from the index 0
        my_map = {0: -1}
        running_sum = 0
        max_count = 0

        for i, item in enumerate(nums):
            if item == 1:
                running_sum += 1
            elif item == 0:
                running_sum -= 1
            
            if running_sum in my_map:
                # To get the length of the balanced sub array we fo i (curr_index) - the index of running sum that's already there in the map
                max_count = max(max_count, i - my_map[running_sum])
            else:
                my_map[running_sum] = i

        return max_count