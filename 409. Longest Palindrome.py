#Time Complexity:O(n)
#Space Complexity:O(n)
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        count=0
        strlist=[]
        for i in range(len(s)):
            if s[i] not in strlist:
                strlist.append(s[i])
            else:
                strlist.remove(s[i])
                count=count+2
        if strlist:
            count=count+1
        return count

            
        
