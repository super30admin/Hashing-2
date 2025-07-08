# Time Complexity:
# O(n)

# Space Complexity:
# O(1)
class Solution(object):
    def longestPalindrome(self, s):
        hashset=set()
        count=0
        for i in range(len(s)):
            if s[i] not in hashset:
                hashset.add(s[i])
            else :
                hashset.remove(s[i])
                count=count+2
        if hashset:
            
            count = count +1
        return count
