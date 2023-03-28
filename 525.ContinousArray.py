# T: O(n)
# S: O(n)

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0

        hashmap = {}
        Max = 0
        rsum = 0
        hashmap[0] = -1
        #[1,0], [0,-1]
        for i in range(len(nums)):
            if nums[i] == 0:
                rsum = rsum - 1
            else:
                rsum = rsum + 1
            if hashmap.get(rsum) == None:
                hashmap[rsum] = i
            else:
                Max = max(Max, i - hashmap[rsum])

        return Max