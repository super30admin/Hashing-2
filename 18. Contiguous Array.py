class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hmap = {0: -1}
        rSum = 0
        result = 0 
        for i in range(len(nums)):
            if nums[i] == 0:
                rSum -= 1
            else: 
                rSum += 1
            if rSum in hmap:
                result = max(result, i -hmap[rSum])
            else: 
                hmap[rSum] = i
                # add.hmap{rSum, i}
        return result

            

        
 
        