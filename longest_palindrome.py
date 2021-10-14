"""
Time Complexity: O(n)
Space Complexity: O(n)
Did your code run on leetcode?: yes
Issues Faced: I was using if hashset != None instead of len(hashset) to check if it's empty and was getting wrong output since size was getting incremented all the time
"""

class Solution:
    def longestPalindrome(self, s: str) -> int:
        size = 0
        hashset = set()
        for x in s:
            if x in hashset:
                size += 2
                hashset.remove(x)
            else:
                hashset.add(x)
        print("hashset=",hashset)
        if len(hashset) != 0:
            size += 1
        return size
