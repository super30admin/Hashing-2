# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

## We use running Sum pattern of the array. All we do is at every number we encounter in the array we keep the running sum and store it in the hashmap.
## we check if our current sum - target lies in the hashmap. we do this because this has already been computed we dont need to count the subarray from that instance to current instance
## if the sum is encountered in the hashmap we had 1 to it else we store at as 1 . this means that the sum has occured these many times.

## V.V.V Important base case is that we initialize the hashmap with 0 sum and 1 occurance as key --> this means that there is already a subarray with sum 0 
##this helps when we encounter the first sum as k in k-k =0 which needs to be present in hashmap
class solution:
    def subArraySum(self, nums, target):

        rSum = {0:1}
        total =0
        res =0
        for i in range(len(nums)):
            total += nums[i]

            if total - target in rSum:
                res+= rSum[total - target]


            if total not in rSum:
                rSum[total] = 1
            else:
                rSum[total]+=1
        
        return res

            

