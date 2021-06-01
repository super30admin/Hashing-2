# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#saving the occurences of each character and checking for even number of
# occurences and saving the one extra odd occurence to put it in middle
class Solution:
    def longestPalindrome(self, s: str) -> int:
        if len(s) == 0:
            return 0
        a = {}
        for i in s:
            if i not in a:
                a[i] = 1
            else:
                a[i] += 1
        palLen = 0
        cont = False
        for i in a:
            if a[i] % 2 == 1:
                cont = True
                palLen += (a[i]-1)
            else:
                palLen += a[i]
        if cont == True:
            return palLen + 1
        return palLen
        