# Time: O(n) to loop throught the array and maintain a running sum
# Space: O(n) To maintain all the running sums

# Maintain a hashmap of the running sums and the time they have occured
# At a particular running sum check if we have y (i.e x - z is the current running sum and x is the target)
# If we have y check how many times it has occered cause the frequency conveys the times the sum of array is then imcrement the count
# z = y + x we have y as target and z as the runnning sum as a particular iteration
# So to find x it's x = z- y

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        my_map = {0:1}
        running_sum = 0
        count = 0
        for num in nums:
            running_sum += num
            if running_sum - k in my_map:
                count += my_map[running_sum - k]

            if running_sum not in my_map:
                my_map[running_sum] = 1
            else:
                my_map[running_sum] += 1
        return count