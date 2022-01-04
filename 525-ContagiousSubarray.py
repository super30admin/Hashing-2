#525 Contagious Subarray
# T.c => o(n)
# S.C => o(n)

#Approach => In this approach we are using a dictionary. Here for every 0 we are decrementing the count and foe every 1 incrementing the count.
#if we found count in maps then we take the max of maps or the count differentiated by i. to find the maximum 0 nad 1's. if its false map the count with i

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if len(nums) == None: return 0
        maps = {}
        maps[0] = -1
        count = 0
        maxs = 0
        for i in range(0, len(nums)):
            if nums[i] == 0:
                count -= 1
            else:
                count += 1
            if count in maps:
                maxs = max(maxs, i - maps[count])
            else:
                maps[count] = i
        return maxs