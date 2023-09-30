1. Palindrome

// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution:
    def longestPalindrome(self, s: str) -> int:
        setofchar = {}
        count = 0
        for i in range(len(s)):
            if s[i] in setofchar:
                count+=2
                del setofchar[s[i]]
            else:
                setofchar[s[i]] = None
        if(len(setofchar)!=0):  
            count+=1
        return count

2. subarraysum

// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        rSumMap = {}
        rSum = 0
        count = 0
        rSumMap[0] = 1
        for i in range(len(nums)):
            rSum += nums[i]
            comp = rSum - k
            if comp in rSumMap:
                count+=rSumMap[comp]
            if rSum in rSumMap:
                rSumMap[rSum]=rSumMap[rSum]+1
            else:
                rSumMap[rSum] = 1
        return count


3. Contugious Array

// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        rSumMap = {}
        rSumMap[0] = -1
        rSum = 0
        maxi = 0
        for i in range(len(nums)):
            if(nums[i]==0):
                rSum-=1
            else:
                rSum+=1
            if rSum in rSumMap:
                maxi = max(maxi,i-rSumMap[rSum])
            else:
                rSumMap[rSum] = i
        return maxi
