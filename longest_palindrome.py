class Solution:
    def longestPalindrome(self, s: str) -> int:
        setChar = set()
        result = 0
        for char in s:
            if char in setChar:
                result += 2
                setChar.remove(char)
            else:
                setChar.add(char)
        
        if len(setChar) > 0:
            result += 1
        return result
