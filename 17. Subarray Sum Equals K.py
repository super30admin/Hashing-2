class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        map = {0: 1}
        rSum = 0
        result = 0 
        for i in nums:
            rSum += i
            compliment = rSum - k 
            if compliment in map:
                result += map[compliment]
            map[rSum] = map.get(rSum, 0) + 1
            #print(result)    
        return result