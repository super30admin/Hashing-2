#Time Complexity: O(N)
#Space Complexity: O(N)


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hashmap = dict()
        rsum = 0
        count = 0
        hashmap[0] = 1
        for i in range(len(nums)):
            rsum = rsum + nums[i]
            if (hashmap.get(rsum) == None):
                hashmap[rsum] = 1
            else:
                hashmap[rsum] = hashmap.get(rsum) + 1
            if rsum - k in hashmap:
                count += hashmap[rsum - k]
        return count

