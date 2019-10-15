#Optimal solution
#O(n) Time and Space complexity

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        dict_counts = {}
        dict_counts[0] = -1
        max_length = 0
        count = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                count -= 1
            else:
                count += 1
            if count in dict_counts.keys():
                max_length = max(max_length, i-dict_counts[count])
            else:
                dict_counts[count] = i
        return max_length