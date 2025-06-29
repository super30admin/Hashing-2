#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        rSum = 0
        maxLen = 0
        map = {0: -1}

        for i in range(len(nums)):
            if nums[i] == 0:
                rSum -= 1
            else:
                rSum += 1

            if rSum in map:
                print(rSum)
                print(map)
                maxLen = max(maxLen, i - map[rSum])
            else:
                map[rSum] = i

        return maxLen

