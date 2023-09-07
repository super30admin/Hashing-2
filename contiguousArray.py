# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dic = {0:-1}
        running_sum = 0
        max_length = 0

        for i in range(0,len(nums)):
            if nums[i] == 0:
                running_sum -= 1
            else:
                running_sum += 1
            if running_sum in dic:
                max_length = max(max_length,i-dic[running_sum])
            else:
                dic[running_sum] = i
        return max_length

