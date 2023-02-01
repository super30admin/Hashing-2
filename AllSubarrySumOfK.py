#All test cases in leetcode passed


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:

        # Here we keep track of the running sum. For every num we add it to running sum.
        # We store the unique running sums in dictionary as key and frequency as val. 
        # We check for each running sum if current (running sum-k) exists in dictionary. 
        # If yes then we increment our result by frequency. If not then we add the running sum 
        # to dictionary with 1 as frequency. We do this because a running 
        # sum can repeat the same sum once again only after adding same k value between it.
        # Time complexity - O(n) - Traversing through every element
        # Space complexity - O(n) - Here dictionary holds every unique running sum, 
        # in worst case all elements can result in unique sum and hence dictionary size is n.
        dict = collections.defaultdict(int)
        res = 0

        rSum = 0
        dict[0] = 1

        for i in range(len(nums)):
            rSum = rSum + nums[i]

            if (rSum-k) in dict:
                res = res + dict[rSum-k]
            dict[rSum]+=1
        return res
            
        