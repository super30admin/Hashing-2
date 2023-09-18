#Time Complexity : O(n) where n is the length of the input string as we iterate through it once
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: We use set as a data structure. We iterate through each character of the string and check it that character is present
# in the set or no. If not, we add it to the set. If the character is present in the set, we increase the count by 2 and remove the
# character from the set. Once we finish iterating through the characters of the string, we check if the set is empty or no. We 
# increase the count by 1 if the set is not empty. In the end return the count which is the length of longest plaindrome that 
# can be formed.

class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = 0
        charset = set()
        for char in s:
            if char in charset:
                 count += 2
                 charset.remove(char)
            else:
                charset.add(char)
        if charset:
            count += 1
        return count