# Time Complexity = o(n) As there is only one for loop
# Space Complexity = o(n) We creating a hashmap with n length

class Solution:
    def findMaxLength(self, nums: list[int]) -> int:

        hashMap = {0: -1}
        maxArr = 0
        rSum = 0
        for i in range(len(nums)):
            if nums[i] == 1:
                rSum += 1
            else:
                rSum -= 1
            if rSum in hashMap:
                temp = i - hashMap[rSum]
                if temp > maxArr:
                    maxArr = temp
            else:
                hashMap[rSum] = i
        return maxArr
