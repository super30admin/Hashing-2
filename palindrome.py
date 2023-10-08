# t - o(n), s - 0(n) 
class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashset = set()
        answer = 0
        for i in range(0,len(s)):
            if s[i] in hashset:
                hashset.remove(s[i])
                answer += 2

            else:
                hashset.add(s[i])

        return answer + 1 if hashset else answer
        