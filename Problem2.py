'''
Problem: Contiguous Array
Time Complexity: O(n), where n is given elements
Space Complexity: O(n), for runsum and dictionary
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        calculate running sum
        use dictionary to store the sums and index
        if sum exists the update maxlen else add to dictionary
'''
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        n = len(nums)
        runsum = [0] * (n+1)
        runsum[0] = -1
        maxlen = 0

        for i in range(n):
            if nums[i]==0:
                runsum[i+1] = runsum[i] - 1
            else:
                runsum[i+1] = runsum[i] + 1

        dicts = {-1 : 0}

        for i in range(1, len(runsum)):
            if runsum[i] in dicts:
                maxlen =max(maxlen, i - dicts[runsum[i]])
            else:
                dicts[runsum[i]] = i

        return maxlen






