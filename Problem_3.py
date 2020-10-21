
"""
Time Complexity : O(n)- as we are iterating through the string, all other operations are O(1)
Space Complexity : O(1)- as there can be only 52 values (26 smaller case and 26 capitals)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
I am using a hashset for this problem which is called set in python. We are also keeping a count to return
length of longest palindrome. While we are iterating through the string, we are keeping a track if a number
already exists in the set or not. If it is already does, it is even for now and can be used to form a 
palindrome. So we remove it from the set and increase our count by two. In case that character is not in the
set, we just add it. At last, we check if the set still has some values in it. If yes, we can pick just one
more character from it inside our palindrome. Hence we increase count by one and return count.
"""


class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        arr = set()
        count = 0
        for i in s:
            if i in arr:
                arr.remove(i)
                count += 2
            else:
                arr.add(i)
        if len(arr) > 0:
            count += 1
        return count
