#Time Complexity: O(n)
#Space Complexity: O(1)
#Did this code successfully run on Leetcode: Yes

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        mapping = {}
        for char in s:
            mapping[char] = mapping.get(char, 0) + 1
        
        count = 0
        flag = False
        for key in mapping:
            freq = mapping.get(key)
            if freq % 2 == 0:
                count += freq
            else:
                count += freq - 1
                flag = True
        
        if flag: return count + 1
        return count

            
        