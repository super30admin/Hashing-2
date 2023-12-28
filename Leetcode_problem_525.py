#problem: Contiguous Array
#time complexity: O(n)
#space complexity: O(1)
#a
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
