class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return False

        sum = 0
        dict = {}
        maxnum = 0
        dict[0] = -1

        for i in range(len(nums)):
            if nums[i] == 0:
                sum -= 1
            else:
                sum += 1
            if sum not in dict:
                dict[sum] = i
            else:
                maxnum = max(maxnum, i - dict[sum])

        return maxnum

# TC: O(n)
# SC: O(n)