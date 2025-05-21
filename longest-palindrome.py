# Count pairs of characters using a set to track unpaired characters as we iterate through the string.
# Each time a pair is found, add 2 to the palindrome length; any leftover unpaired character can be used in the center.
# The result is the length of the longest palindrome that can be built from the input string.

# Time Complexity : O(n)
# Space Complexity : O(1) because the set will contain at most 52 characters
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def longestPalindrome(self, s: str) -> int:
        if s is None or len(s) == 0:
            return 0
        
        count = 0
        charSet = set()
        
        for char in s:
            if char in charSet:
                count += 2
                charSet.remove(char)
            else:
                charSet.add(char)
                
        if len(charSet) > 0:
            count += 1
            
        return count
    
    
    