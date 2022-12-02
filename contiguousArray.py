# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

## We use running Sum pattern of the array. All we do is at every number we encounter in the array we keep the running sum and its index in the hashmap.
## we check if our current sum lies in the hashmap. We do this because if we encounter at any other instance the same sum that means the array is balanced and the difference between
## current index and the prev occurance will the length
## V.V.V Important base case is that we initialize the hashmap with 0 sum and -1 index as key --> this means that a sum 0 has appened already outside of array and we 
## giving index as -1, so if we encount a balances array[1,0] or [0,1] total sum is 0 and ) :-1 so length will be 1 -(-1) =2
class Solutoin:
    def contiguous(self, nums):

        rSum = {0:-1}
        total = 0
        res = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                total -=1
            else:
                total+=1
            if total not in rSum:
                rSum[total] = i
            else:
                res = max(res, i - rSum[total])
        
        return res


