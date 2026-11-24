#Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

# Analysis: We can solve this problem using running sum + hashing.

#Time complexity: O(n)

#space complexity: O(n)
#-1 0 1 2 3 4 3 2 1 -> RS
#[0,1,1,1,1,1,0,0,0]
# 0 1 2 3 4 5 6 7 8 -> Idx

# 0 : -1
#-1 :  0
# 1 :  2
# 2 :  3
# 3 :  4
# 4 :  5


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        map = {}
        map[0] = -1
        runSum = 0
        maxLength = 0
        for i in range(len(nums)):
            if nums[i] == 1:
                runSum += 1
            else:
                runSum -= 1
            if runSum in map:
                maxLength = max(maxLength, i - (map[runSum]))
            else:
                map[runSum] = i
        return maxLength
            