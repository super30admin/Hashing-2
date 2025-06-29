# // Time Complexity : O(n) 
# // Space Complexity : O(n)

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hashMap = {0 : 1}
        sumArr = 0
        count = 0

        for i in range(0,len(nums)):

            sumArr = nums[i] + sumArr
            if( (sumArr - k) in hashMap):
                count += hashMap[sumArr - k]
            hashMap[sumArr] = hashMap.get(sumArr,0) + 1

        return count
        