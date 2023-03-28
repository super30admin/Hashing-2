#Time Complexity: O(n), where n is the length of the input string s
#Space Complexity: O(n), where n is the length of the input string s

class Solution:
    def longestPalindrome(self, s: str) -> int:
        if s == None or len(s) == 0:
            return 0
        hashset = set()
        total = 0
        for i in range(len(s)):
            if s[i] in hashset:
                total = total + 2
                hashset.remove(s[i])
            else:
                hashset.add(s[i])
        if len(hashset) != 0:
            total = total + 1
        return total