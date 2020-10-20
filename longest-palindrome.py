# Time Complexity: O(n)
# Space Complexity: O(n)
# Did it run on Leetcode: Yes
# Did you face any issues: No
# Approach:
# Just going by the basic semantic definition of a palindromic string - 
# Even number of occurances of any character
# OR
# Even number of occurances of any character + 1 centre or pivot character that divides other characters in equal pairs on either side
# Build a map with counts of every character
# Iterate over the values, for every value, the even component (v//2*2) can participate in a palindrome - ADD this to result
# If the current value is odd and the resultant string has even length, we can add the extra "centre" character to the result

from collections import Counter
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        cnt = Counter(s)
        res = 0
        for v in cnt.values():
            res += v//2*2 # Adding the even component for every value
            if res%2 == 0 and v%2 == 1: # current value is odd, resultant string formed after adding the even component is even, so add 1 character to the result
                res += 1
                
        return res