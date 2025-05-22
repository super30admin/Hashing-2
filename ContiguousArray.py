#RUNNING SUM:z=x-y :HashMap
#TC: O(n)
#SC: O(1)

# Iterate through the array, treating 0 as -1 and 1 as +1 to maintain a running count.
# Increment the count by -1 when a 0 is found and by +1 when a 1 is found.
# If the running count becomes 0 at any point, it means the subarray from the start to that index has equal 0s and 1s,
# so update the max length to the current index + 1.
# Store the first occurrence of each count in a map.
# If the current count has been seen before, it means the subarray between the previous index and the current index is balanced,
# so update the max length to the maximum of the current max and the distance between indices.

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        index_map = {}  # Dictionary to store first occurrence of a running count
        max_length = 0
        count = 0  # Running count: +1 for 1, -1 for 0

        for i in range(len(nums)):
            # Treat 0 as -1 to use running sum for balance between 0s and 1s
            if nums[i] == 0:
                count -= 1
            else:
                count += 1

            # If count is 0, entire array from 0 to i is balanced
            if count == 0:
                max_length = i + 1

            # If count was seen before, subarray from previous index + 1 to i is balanced
            if count in index_map:
                max_length = max(max_length, i - index_map[count])
            else:
                index_map[count] = i

        return max_length
