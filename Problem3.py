
class Solution:
def longestPalindrome(self, s: str) -> int:
hashm = [0]*52
count = 0
for i in range(len(s)):
    if hashm[ord(s[i])-96] == 1:
        hashm[ord(s[i])-96] = 0
        count = count+2
    else:
        hashm[ord(s[i])-96] = 1
if count!=len(s):
    return count+1
else:
    return count
