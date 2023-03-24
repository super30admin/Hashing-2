// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
## Hsh Map: o(n)
## space complexcity : 0(1)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hashMap = {}
        rsum = 0
        total = 0
        # 
        hashMap[rsum] = 1
        for i in range(len(nums)):
            rsum = rsum + nums[i] ## Finding the sum
            if hashMap.get(rsum - k) != None:
                total = total + hashMap[rsum -k]
            if hashMap.get(rsum) != None:
                hashMap[rsum] = hashMap[rsum] + 1
            else:
                hashMap[rsum] = 1
        return total

Problem2 (https://leetcode.com/problems/contiguous-array/)

# time complexcity = o(n)
# space complexcity = o(n) rsum
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        hashMap = {}
        Max = 0
        rSum = 0
        hashMap[0] = -1
        for i in range(len(nums)):
            if nums[i] == 0:
                rSum = rSum -1
            else:
                rSum = rSum + 1
            if hashMap.get(rSum) == None:
                hashMap[rSum] = i
            else:
                Max = max(Max, i - hashMap[rSum])
        return Max

## Problem3 (https://leetcode.com/problems/longest-palindrome)
## Time complexcity: o(n)
## space complexcity : o(1)
class Solution:
    def longestPalindrome(self, s: str) -> int:
        if s==None or len(s) ==0:
            return 0
        Hashset = set()
        length = 0
        for i in s:
            if i in Hashset:
                Hashset.remove(i)
                length += 2
            else:
                Hashset.add(i)
        if len(Hashset):
            length += 1
        return length