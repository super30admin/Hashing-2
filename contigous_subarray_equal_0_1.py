# TC: O(n)
# SC : O(n)

class Solution:
    def findMaxLength(self, nums):
        hashmap = {}
        hashmap[0] = -1
        maximum = 0
        rSum = 0
        for i in range(len(nums)):
            # print(nums[i])
            if nums[i] == 0:
                rSum -= 1
            else:
                rSum += 1
            if rSum in hashmap:
                # Calculate the max = differnce between current index and the earlier index in hashmap
                maximum = max(hashmap[rSum] , rSum - i)
        return(maximum)