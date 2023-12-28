#problem: Contiguous Array
#time complexity: O(n)
#space complexity: O(1)
#approach: using hashmap to store the running sum and its index. If the running sum is already in the hashmap, we update the max_length by max(max_length, i - hashmap[running_sum]). If the running sum is not in the hashmap, we add it to the hashmap.
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hashmap = {0: -1}
        running_sum = 0
        max_length = 0

        for i in range(len(nums)):
            if nums[i] == 0:
                running_sum -= 1
            else:
                running_sum += 1

            if running_sum in hashmap:
                max_length = max(max_length, i - hashmap[running_sum])
            else:
                hashmap[running_sum] = i

        return max_length
