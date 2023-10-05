#Time and Space: O(N)
class Solution:
    def longestPalindrome(self, s):
        c=0
        hsh=set()
        for i in s:
            if i not in hsh:
                hsh.add(i)
            else:
                hsh.remove(i)
                c+=2
        if len(hsh)>0:
            return c+1
        else:
            return c
