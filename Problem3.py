'''
Problem: Longest Palindorm
Time Complexity: O(n), where n is given elements
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        Maintain a counter dictionary
        Iterate over dictionary to get even characters
        add 1 extra to account for odd element  
'''
class Solution:
    def longestPalindrome(self, s: str) -> int:
        dicts = Counter(s)
        count = 0
        isodd = False

        for key, val in dicts.items():
            if val%2==0:
                count+=val
            else:
                isodd = True
                count+= val//2 * 2

        if isodd:
            count+=1
        
        return count