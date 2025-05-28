# Problem #18 Contiguous Binary Subarray
#525 https://leetcode.com/problems/contiguous-array/

# Author : Akaash Trivedi
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #525
# Any problem you faced while coding this : No

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hashm = {0:-1}
        maxLen = 0
        rSum = 0 #running sum
        for i, num in enumerate(nums):
            if num == 1:
                rSum += 1
            else:
                rSum -= 1
            if rSum in hashm:
                # index minus where it first occur
                maxLen = max(maxLen, i- hashm[rSum])
            else:
                hashm[rSum]=i
        return maxLen
