# Explain your approach in **three sentences only** at top of your code
#  maintain a hash set to check which char have been visited if a char is found again update res since we found pair otherwise continue
#  if at the end hashset is not null that means the remaining eleent has odd count so only include 1 of them in resul for odd length paindrome


class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashSet, res = set(), 0
        for i in range(len(s)):
            if s[i] not in hashSet:
                hashSet.add(s[i])
            else:
                res+=2
                hashSet.remove(s[i])
        if hashSet:
            res+=1
        return res



        