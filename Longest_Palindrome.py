class Solution:
    def longestPalindrome(self, s: str) -> int:

        count=0
        a_set=set()

        for i in range(len(s)):
            if s[i] not in a_set:
                a_set.add(s[i])
            else:
                count=count+2
                a_set.remove(s[i])
        if len(a_set)>0:
            return count+1
        else:
            return count

        