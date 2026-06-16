# LEETCODE PROBLEM 409 LONGEST PALINDROME
# TIME COMPLEXITY: O(N) where N is the number of elements in a given array
# SPACE COMPLEXITY: O(1) 
# Any problem you faced while coding this: None

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        set_char=set()
        count=0

        for i in s:
            if i in set_char:
                count+=2
                set_char.remove(i)
            else:
                set_char.add(i)
        if len(set_char)>0:
            return count+1
        return count
    