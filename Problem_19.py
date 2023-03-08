# TC: O(N), SC: O(K), K => max running_sums
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        dict1 = {0:-1}
        running_sum = 0
        max_in = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                running_sum -= 1
            else:
                running_sum += 1
            if running_sum in dict1:
                max_in = max(max_in, i - dict1[running_sum])
            else:
                dict1[running_sum] = i

        return max_in

            