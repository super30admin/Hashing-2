#Time complexity: O(n)
#Space complexity: O(n)

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hashmap = dict()
        hashmap[0] = 1
        rsum = 0
        count = 0

        for i in range(0, len(nums)):
            rsum = rsum + nums[i]
            
            if rsum - k in hashmap:
                count = count + hashmap[rsum - k]
            
            if rsum not in hashmap:
                hashmap[rsum] = 0

            hashmap[rsum] = hashmap[rsum] + 1
        
        return count
