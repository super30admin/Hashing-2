#Time Complexity : O(n) ... n is number of elements 
#Space Complexity : O(n)
#Any problem you faced while coding this : faced issue with the base case, therefore added initial value

#Used the approach of storing the ruuning sum and for each iteration a check was performed to find whether the difference between the target value and current sum is present or not in the hash map

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        check = {0:1}
        subArr = 0
        runSum = 0

        for idx, num in enumerate(nums):
            runSum += num
            # print("runSum = ", runSum)
            # print("keys =",check.keys())
            if runSum - k in check.keys():
                subArr += check[runSum - k]
                # print("SubArr",subArr)
            if runSum in check.keys():
                check[runSum] += 1
            else:
                check[runSum] = 1
            # print(check)
        return subArr