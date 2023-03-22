class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        hashMap = {}
        Max = 0
        rSum = 0
        hashMap[0] = -1
        for i in range(len(nums)):
            if nums[i] == 0:
                rSum = rSum - 1
            else:
                rSum = rSum + 1
            if hashMap.get(rSum) == None:
                hashMap[rSum] = i
            else:
                Max = max(Max , i - hashMap[rSum])
        return Max