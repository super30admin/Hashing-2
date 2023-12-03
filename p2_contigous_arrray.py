class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        count = 0
        cont_array = dict([(0, -1)])
        result = 0
        for i in range(0,len(nums)):
            if nums[i] == 0:
                count -= 1
            else:
                count += 1
            if count not in cont_array:               
                cont_array[count] = i
            else:
                result = max(result, i - cont_array[count])
        return result