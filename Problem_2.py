'''
Time Complexity - O(n), we iterate the array
Space Complexity - O(n), we store the running sum all elements in worst case

This code works on Leetcode
'''

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        rSum = 0
        maxSize = 0
        sumMap = {}
        sumMap[0] = -1
        for i in range(len(nums)):
            if nums[i] == 1:
                rSum+=1 #increment running sum by 1 if element is 1
            else:
                rSum-=1 #decrement running sum by 1 if element is 0
            if rSum in sumMap: #if this rSum is previously present
                lastPos = sumMap.get(rSum) #we get the earliest index with same rSum as the subarray from that index to current index is balanced
                maxSize = max(maxSize, i - lastPos) #calculate the length of the subarray and compare with the max size.
            else:
                sumMap[rSum] = i # else just add the rSum to the hashMap.
        return maxSize
        