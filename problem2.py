#Time Complexity : O(n) ... n is number of elements 
#Space Complexity : O(n)
#Any problem you faced while coding this : No

#Used the approach of storing the ruuning sum and for each iteration a check was performed to find the maximum length of the balanced range

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        check = {0:-1}
        sum = 0
        maxSum = 0
        for idx, num in enumerate(nums):
            if num == 1:
                sum += 1
            else:
                sum -= 1
            if sum in check.keys():
                maxSum = max(maxSum, idx - check[sum])
            else:
                check[sum] = idx
        

        return maxSum

