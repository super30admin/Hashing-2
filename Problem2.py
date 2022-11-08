#Time complexity: O(n)
#Space complexity: O(n) for storing hashmap

#Accepted on Leetcode 

#Approach: 
#Maintain a running sum(starting from 0) and a Hashmap (with dummy entry 0: -1)
#For each occurrence of 0, minus one from the rSum and for each occurrence of 1, add 1
#For any rSum, store first occurrence in hashMap(value = index)
#Each subsequent occurrence of that rSum indicates that number of 0's & 1's between those two indices of the array is equal
#Maintain a count variable and change it each time a higher count is encountered


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        
        count = 0
        rSum = 0
        hashMap = {}
        hashMap[0] = -1 #dummy entry

        for index, elem in enumerate(nums):
            rSum = rSum + 1 if elem == 1 else rSum - 1
            if rSum in hashMap:
                count = max(count, index - hashMap[rSum])
            else:
                hashMap[rSum] = index
            
        return count

#TC [0, 0, 1, 0, 1]
# HM = {0: -1}, rSum = 0, count = 0
# i = 0, elem = 0, rSum = -1, HM = {0: -1, -1: 0}
# i = 1, elem = 0, rSum = -2, HM = {0: -1, -1: 0, -2: 1}
# i = 2, elem = 1, rSum = -1, HM = {0: -1, -1: 0, -2: 1}, -1 Reoccurs, count = 2
# i = 3, elem = 0, rSum = -2, HM = {0: -1, -1: 0, -2: 1}, -2 Reoccurs, count = max(2, 3-1) = 2
# i = 4, elem = 1, rSum = -1, HM = {0: -1, -1: 0, -2: 1}, -1 Reoccurs, count = max(2, 4-0) = 4
#Return 4