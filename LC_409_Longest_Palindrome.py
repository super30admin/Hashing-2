
#TC- O(N)

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """

        count = 0
        charSet = {} #HashSet

        for char in s:
            if char not in charSet:
                charSet[char] = 1
            else:
                count = count+2 # increment by 2, since we need a pair on each end to make a palindrome
                del charSet[char] # once a pair is found, make space for new pair(can be a repeat letter)
        
        if len(charSet)>0: 
            return count+1
        else:
            return count


