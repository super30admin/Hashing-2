 # Time complexity - o(n)
 # Space complexity - o(n)
class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        hashChar = set()
        result = 0


        for c in s:
            if c in hashChar:
                result+=2
                hashChar.remove(c)
            else:
                hashChar.add(c)

        return result if len(hashChar)==0 else result+1
