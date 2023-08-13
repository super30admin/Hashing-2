# Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
class Solution:
    def subarraySum(self, nums, k):
        # variable for running sum, count
        rsum = count = 0
        # hashmap for {rsum: freq}
        hmap = {}
        # with dummy value of 0: 1
        hmap[0] = 1
        # iterating over the nums array
        for i in range(len(nums)):
            # find the rsum
            rsum += nums[i]
            # get complement
            complement = rsum - k
            # check if complement is present in hmap
            if complement in hmap:
                count += hmap[complement]
            hmap[rsum] = hmap.get(rsum, 0) + 1
        return count


nums = [1, 1, 1]
k = 2
sol = Solution()
print(sol.subarraySum(nums, k))
