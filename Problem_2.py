class Solution:
    def findMaxLength(self,nums):
        sum_index = {0: -1}
        curr_sum = 0
        result = 0
        for i in range(len(nums)):
            curr_sum += 1 if nums[i] == 1 else -1
            if curr_sum in sum_index:
                result = max(result, i - sum_index[curr_sum])
            else:
                sum_index[curr_sum] = i
        return result

nums = [0,1,1,1,1,1,0,0,0]

sl = Solution()
print(sl.findMaxLength(nums))