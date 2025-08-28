## Problem3 (https://leetcode.com/problems/longest-palindrome)

# Time Complexity : O(N)
# Space Complexity : O(52) = O(1) -- s consists of lowercase and/or uppercase English letters only.
# Did this code successfully run on Leetcode : Tes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# From the given string we check how many characters we can have of even occurrences. Total occurrences of any character can be odd or 
# even. We just take the max even value from the occurences. For this we keep a set. Whenever a character gets repeated, we add +2 to 
# our max palindrome length and remove the character from the set as it already got paired. At the end we check do we have any elements
# left in the set, if yes it means we have some character/characters with odd length. So we add +1 to our max palindrome length as we can
# have palindrome with odd length


class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        # Method 1: Using Hashset
        countSet = set()
        longestCount = 0
        for i in s:
            if(i in countSet):
                longestCount += 2
                countSet.discard(i)
            else:
                countSet.add(i)

        if(countSet):
            longestCount += 1

        return longestCount

sol = Solution()
print(sol.longestPalindrome("abccccdd"))
print(sol.longestPalindrome("ab"))
print(sol.longestPalindrome("a"))
print(sol.longestPalindrome("abccdcbcaadb"))