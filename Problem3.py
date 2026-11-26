# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#Approach: 1. Initiate a seen set that tracks last occurance of the chars and maxLen.
#          2. If a char exists in the set that means we now have 2 occurances of a char, so we add 2 to the current maxLen. And, we remove the current char key tp avoid duplicates whenthe char is found again.
#          3. Else, we add the new char to the set. At the end, if seen is empty, that means we had all chars with even counts else we had one or many single occuring chars, one of which can be used in the palindrome.



class Solution:
    def longestPalindrome(self, s: str) -> int:
        seen = set()
        maxLen = 0

        for char in s:
            if char in seen:
                maxLen += 2
                seen.remove(char)
            else:
                seen.add(char)
        return maxLen if not seen else maxLen + 1
