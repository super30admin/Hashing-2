#All test cases in leetcode passed

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        # Here we keep track of the running sum. For every 0 we add -1 and for every 1 we add 1. 
        # We store the unique running sums in dictionary as key and index as val. 
        # If the running sum is repeated then we subtract current index - running sum's dictionary 
        # stored index, this value is added to fnal result. We do this because a running 
        # sum can repeat the same sum once again only after adding same number of 0's and 1's between it.
        # Time complexity - O(n) - Traversing through every element
        # Space complexity - O(n) - Here dictionary holds every unique running sum, 
        # in worst case all elements can be 1's and hence dictionary size is n.
        res = 0
        rSum = 0
        dict = {0:-1}

        for i in range(len(nums)):
            if nums[i]==0:
                rSum = rSum - 1
            else:
                rSum = rSum + 1

            if rSum in dict:
                res = max(res, i-dict[rSum])
            else:
                dict[rSum] = i
        return res



        