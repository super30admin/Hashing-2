// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 1. Store prefix sum of the input array
// 2. Use a map to store the (rsum, index) value of the input (Goal is to keep track of the earliest index of the prefix sum, so we can find the longest contiguous subarray)
// 3. Iterate through the prefix sum array. If the prefix sum keu exists in the map, then store the index of the prefix sum. Else, find the diff between current index and the index of the prefix sum. Store the maximum value of this difference at every occurence



from collections import defaultdict
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        rsum = [0] * len(nums)
        summ = 0

        for i in range(len(nums)):
            if nums[i] == 1:
                summ += 1
            else:
                summ -= 1
            rsum[i] = summ

        mapp = defaultdict(int)
        mapp[0] = -1

        maxx = 0
        for i in range(len(rsum)):
            if rsum[i] not in mapp:
                mapp[rsum[i]] = i
            else:
                diff = i - mapp[rsum[i]]
                maxx = max(maxx, diff)
        
        return maxx
