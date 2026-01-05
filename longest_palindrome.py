''' Time Complexity : O(n)
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : if char already present in set, means we found 1 pair, increament count by 2,
              else add char to set,
              at end, it set has stil has element, we can add 1 to the count
'''
class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashset=set()
        count = 0
        for c in s:
            if c in hashset:
                count += 2
                hashset.remove(c)
            else:
                hashset.add(c)
        if hashset:
            count += 1
        return count