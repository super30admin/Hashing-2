"""
Approach: we can look at the array as a line diagram with goes up and comes down. equal number od 0's and 1's mean ups and dips are 
nullified. i.e. line comes back to center. prefixSum principle - subarray sum is 0 whenever prefixsum[i] is same. therefore treat
0's and -1 and 1 as +1 and take prefixSum.
"""
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        sums = 0
        res = 0

        index = collections.defaultdict(int)
        index[0] = -1 #base case that current subarray from 0-i has equal 0's and 1's
        for i in range(len(nums)):
            if nums[i] == 0:
                sums -= 1
            else:
                sums += 1
            if sums in index:
                res = max(res, i - index[sums])
            else:
                index[sums] = i
        return res
            

            