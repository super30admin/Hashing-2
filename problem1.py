# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        dict1 = {0: 1}
        running_sum = 0
        count = 0
        for i in range(len(nums)):
            running_sum += nums[i]
            if (running_sum - k) in dict1:
                count += dict1[running_sum - k]
            if running_sum not in dict1:
                dict1[running_sum] = 0
            dict1[running_sum] += 1

        return count