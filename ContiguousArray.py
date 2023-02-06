# Author: Naveen US
# Title: Contigous Array

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes


def findMaxLength(self, nums: List[int]) -> int:
    rsum = {0:-1}  # rsum:idx # starting with 0:-1
    count = 0
    result = 0
    for i in range(len(nums)):
        if nums[i] == 0:
            count = count - 1
        else: count = count +1

        if count in rsum:
            result = max(i - rsum[count],result) # checking the maximum of new balenced array and res
        else:
            rsum[count] = i
    return result
