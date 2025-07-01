# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def longestPalindrome(self, s):
        if len(s) == 1:
            return 1
        letter_count_map = {}
        length = 0
        odd_val = False
        for i in range(len(s)):
            if s[i] in letter_count_map:
                letter_count_map[s[i]] = letter_count_map[s[i]] + 1
            else:
                letter_count_map[s[i]] = 1
        for i in letter_count_map.values():
            if (i % 2) == 0:
                length = length + i
            else:
                length = length + i - 1
                odd_val = True
        if odd_val == False:
            return length
        else:
            return (length + 1)
            
#obj = Solution()
#sol1 = obj.longestPalindrome("abccccdd")
#print(sol1)
#sol2 = obj.longestPalindrome("a")
#print(sol2)
#sol3 = obj.longestPalindrome("ccc")
#print(sol3)