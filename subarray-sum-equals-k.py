class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if nums == None or len(nums) == 0:
            return 0
        hashMap = {}
        rSum = 0
        count = 0
        hashMap[0] = 1
        for i in range(len(nums)):
            rSum = rSum + nums[i]
            if hashMap.get(rSum-k) != None:
                count = count + hashMap.get(rSum - k)
            if hashMap.get(rSum) != None:
                hashMap[rSum] = hashMap[rSum] + 1
            else:
                hashMap[rSum] = 1
            
        return count

