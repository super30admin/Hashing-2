#Time complexity: O(N)
#Space complexity: O(N)

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:

        hashmap = {}
        maxx = 0 
        rsum = 0 

        hashmap[0] = -1

        for i in range(len(nums)):
            if nums[i] == 0:
                rsum = rsum - 1
            else:
                rsum = rsum + 1

            if rsum not in hashmap:
                hashmap[rsum] = i
            else:
                curr = i - hashmap[rsum]
                maxx = max(maxx, curr)

        return maxx


