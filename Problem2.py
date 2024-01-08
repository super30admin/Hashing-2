# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        # res = 0
        # for i in range(len(nums)):
        #     num_0 = 0
        #     num_1 = 0
        #     if nums[i] == 0:
        #         num_0 = 1
        #     else:
        #         num_1 = 1
        #     for j in range(i+1, len(nums)):
        #         if nums[j] == 0:
        #             num_0 += 1
        #         else:
        #             num_1 += 1
        #         if num_0 == num_1:
        #             res = max(res, j - i + 1)
        
        # return res
        map = {}
        map[0] = -1
        running_sum = 0
        res = 0

        for i in range(len(nums)):
            if nums[i] == 0:
                running_sum -= 1
            else:
                running_sum += 1
            
            if running_sum in map:
                res = max(res, i - map[running_sum])
            else:
                map[running_sum] = i
        
        return res
