# Hashing-2
# 
## Problem1 (https://leetcode.com/problems/subarray-sum-equals-k/)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        r_sum = 0
        hashMap = {0:1} #Key:Index, Value: How many times we have seen the sum so far
        count = 0
        for i in range(len(nums)):
            r_sum+=nums[i] 
            if r_sum - k in hashMap:       
                count+= hashMap[r_sum-k] 
            if r_sum in hashMap:
                hashMap[r_sum]+=1
            else:
                hashMap[r_sum]=1
        return count

# Time Complexity: O(n)
# Compiled in Leetcode
            

## Problem2 (https://leetcode.com/problems/contiguous-array/)
# Running sum problem. Idea: If we see the same running sum between two different 
# indices, then the sum between them is 0. 
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hashMap = {0:-1}    # Running sum at index -1 is 0
        r_sum = 0
        maximum = 0
        for i in range(len(nums)):
            if nums[i] == 1:
                r_sum+=1
            else:
                r_sum-=1
            if r_sum in hashMap:
                maximum = max(maximum, i - hashMap[r_sum])   #Tracking maximum
            else:
                hashMap[r_sum] = i
        return maximum

# Time Complexity: O(n)
# Compiled in Leetcode

## Problem3 (https://leetcode.com/problems/longest-palindrome)
# Idea: Add character to hashset if not seen. Remove if seen. This way we know that 
# we have seen even number of character count if it's not present in hashset. Add a 
# +1 as we can have a odd length palindrome (if present in hashset)
class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashSet = set()
        for c in s:
            if c in hashSet:
                hashSet.remove(c)
            else:
                hashSet.add(c)
        if len(hashSet)>0:
            return len(s)-len(hashSet)+1
        else:
            return len(s)

# Time Complexity: O(n)
# Compiled in Leetcode