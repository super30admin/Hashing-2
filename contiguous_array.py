def class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if nums == 0 or len(nums) == 0:
            return 0
        hashMap = {}
        hashMap[0] = -1
        rSum = 0
        Max = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                rSum = rSum - 1
            else:
                rSum = rSum + 1
            if hashMap.get(rSum) != None:
                Max = max(Max, i-hashMap.get(rSum))
            else:
                hashMap[rSum] = i
        return Max




        



        