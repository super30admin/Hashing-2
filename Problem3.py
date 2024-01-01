# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Problem3 (https://leetcode.com/problems/longest-palindrome)
# we store the unique letters into our set by iterating over our string, if we find a letter in our set that means we have seen this letter before ergo it can help be a palindrome
# so then we increase the count by 2 and remove the letter from our set otherwise its added 

class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = 0
        uniqueLetters = set()

        for letter in s:
            if letter in uniqueLetters:
                count += 2
                uniqueLetters.remove(letter)
            else:
                uniqueLetters.add(letter)
        
        if len(uniqueLetters) > 0:
            count += 1

        return count