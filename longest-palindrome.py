# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashSet = set()
        count = 0

        for i in s:
            if i in hashSet:
                count += 2
                hashSet.remove(i)
            else:
                hashSet.add(i)
        
        return count if len(hashSet)==0 else count + 1