#Longest Palindrome

# High level idea is to get the frequency count of all the chars in s
# add al even ones and in final 1 if there exists atleast 1 odd ocurence of any character
class Solution:
    def longestPalindrome(self, s: str) -> int:
        charSet = set()
        count=0
        for char in s:
            if char in charSet:
                charSet.remove(char)
                count+=2
            else:
                charSet.add(char)

        if count < len(s):
            count+=1
        return count