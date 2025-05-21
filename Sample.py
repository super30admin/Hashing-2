# Problem 1: Longest Palindrome
# Using hashset, add character if not in set. if in set, increment length variable by 2 and remove character from set. if at the end set is not empty, add 1 to length (odd size).

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def longestPalindrome(self, s: str) -> int:
        hs=set()
        l=0
        if len(s)==1:
            return 1
        for i in s:
            if i in hs:
                l+=2
                hs.remove(i)
            else:
                hs.add(i)
        if hs:
            l+=1
        return l


# Problem 2: Contiguous Array
# Use hasmap with running sum ( sum-1 for 0s ) as key. And initialize with {0:-1} for the edge case where index 0 also has to be included. And for value, just use index of the running sum.

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        m={0:-1}
        rs=0
        l=0
        for i,j in enumerate(nums):
            if j==1:
                rs+=1
            else:
                rs-=1
            
            if rs in m:
                l=max(l, i-m[rs])
            else:
                m[rs]=i
        return l
    

# Problem 3: Subarray sum equals k
# Use hashmap with running sum, but this time store count as value instead of index. Check if (running sum - target) exists in map, if so, increment count.
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if len(nums)==1 and nums[0]!=k:
            return 0
        m={0:1}
        tc=0
        rs=0
        for i in nums:
            rs+=i
            if rs-k in m:
                tc+=m[rs-k]
            if rs not in m:
                m[rs]=0
            m[rs]+=1
        
        return tc
