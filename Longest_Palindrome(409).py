# Time Complexity: O(N)
# Space Complexity: O(1) as the set can have max of 52 unique values
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The logic here is that we can form a palindrome when there are even number of same characters
# and maybe one unique character to be inserted in the middle of the string
class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = 0
        char_set = set()

        # we iterate through the list and add the character to the set
        # if the set already has the character we add 2 since we encountered the charater 2 times
        # and pop the character out of the set so that if encountered again we can repeat this process

        for char in s:
            if char in char_set:
                count+=2
                char_set.remove(char)
            else:
                char_set.add(char)

        # if there are characters present in the set, we can add 1 character in the middle without affecting
        # the palindromic property of the string
        if len(char_set):
            count+=1

        return count