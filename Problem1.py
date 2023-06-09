'''
Problem: Contiguous Array
Time Complexity: O(n), where n is given elements
Space Complexity: O(n), for runsum and dictionary
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        calculate running sum
        use dictionary to store the sums and no of time it happened
        return the count at the end
'''

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        runsum = [0] * (n+1)
        runsum[0] = 0
        count = 0

        for i in range(n):
            runsum[i+1] = runsum[i] + nums[i]
        
        dicts={0:1} #0 happened once

        for i in range(1,len(runsum)):
            if runsum[i]-k in dicts:
                count+= dicts[runsum[i]-k]
            
            if runsum[i] not in dicts:
                dicts[runsum[i]] = 1
            else:
                dicts[runsum[i]] += 1
        
        return count