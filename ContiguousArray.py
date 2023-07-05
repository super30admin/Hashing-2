#Time complexity: O(n)
#Space complexity: O(n)

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        max_length = 0
        count = 0
        length = 0
        mapping = {0:-1}
        for i in range(len(nums)):
            if nums[i] == 0:
                count = count - 1
            else:
                count = count +1

            if count in mapping:
                length = i - mapping[count]
            else:
                mapping[count] = i
        
            max_length  = max(length, max_length)
        return max_length