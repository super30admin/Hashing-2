"""
I use a hash set to track characters: when a character appears the first time, I add it; when it appears again, I remove it and increase the count by 2. This way, pairs of characters are counted immediately. At the end, if any characters remain unpaired, I add 1 to include one odd character in the palindrome center.
Time Complexity: O(n)
Space Complexity: O(1) 
"""
class Solution:
    def longestPalindrome(self, s: str) -> int:
        charSet = set()
        result = 0
        for char in s:
            if char not in charSet:
                charSet.add(char)
            else:
                charSet.remove(char)
                result += 2
        if charSet:
            result += 1
        return result

