#Time complexity: O(n)
#Space complexity: O(n)

#Accepted on Leetcode

#Approach:
#If the runningSum - k (i.e required sum) at any index is equal to a previous runningSum
#It means the subArray sum from that previous runningSum to current index equals k
# => If (rSum - k) has occured before, count += (number of times rSum - k) has occurred before
# Maintain a hashMap to keep track of how many times a given rSum occurs
# At the start rSum is 0 so initialize hashMap as {0: 1}

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        rSum = 0
        hashMap = {0: 1}

        for val in nums:
            rSum += val
            if rSum - k in hashMap:
                count += hashMap[rSum - k]
            
            if rSum in hashMap:
                hashMap[rSum] += 1
            else:
                hashMap[rSum] = 1
        return count

#TC 1
# [0, 0], k = 0
# i = 0, HM = {0: 1}, val = 0, rSum = 0, rSum - k = 0, count = count + 1 = 1, HM = {0: 2}
# i = 1, HM = {0: 2}, val = 0, rSum = 0, rSum - k = 0, count = count + 2 = 3, HM = {0: 3}
#Return 3

#TC 2
#[1, 3, 2, 3, 4, 5] k = 9
# i = 0, HM = {0: 1}, val = 1, rSum = 1, rSum - k = -8, count = count, HM = {0:1, 1: 1}
# i = 1, HM = {0: 1, 1: 1}, val = 3, rSum = 4, rSum - k = -5, count = count, HM = {0:1, 1: 1, 4: 1}
# i = 2, HM = {0: 1, 1:1, 4:1}, val = 2, rSum = 6, rSum - k = -3, count = count, HM = {0:1, 1: 1, 4: 1, 6: 1}
# i = 3, HM = {0:1, 1:1, 4:1, 6:1}, val = 3, rSum = 9, rSum - k = 0, count = count + 1 = 1, HM = {0:1, 1: 1, 4: 1, 6: 1, 9: 1}
# i = 4, HM = {0:1, 1: 1, 4: 1, 6: 1, 9: 1}, val = 4, rSum = 13, rSum - k = 4, count = count + 1 = 2, HM = {0:1, 1: 1, 4: 1, 6: 1, 9: 1, 13: 1}
# i = 5, HM = {0:1, 1: 1, 4: 1, 6: 1, 9: 1}, val = 5, rSum = 18, rSum - k = 9, count = count + 1 = 3, HM = {0:1, 1: 1, 4: 1, 6: 1, 9: 1, 13: 1, 18: 1}






            