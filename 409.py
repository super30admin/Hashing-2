class Solution:
    def longestPalindrome(self, s: str) -> int:
        charset = [0]*58 # there are 6 chars in between A-Z range and a-z range
        total = 0
        oddCounter = 0
        for c in s:
            cidx = ord(c) - ord('A')
            if charset[cidx]==0:
                charset[cidx]=1
                oddCounter +=1
            else:
                total += 2
                charset[cidx]=0
                oddCounter -= 1
        if oddCounter > 0:
            total += 1
        return total

