"""Using HashSet: Iterate over the given string and for every character thats not in the
HashSet, add it. If ots already present, delete it and increase counter by 2. Repeat the
process all of s. Retrun counter after checking if its not empty, then add one to the counter.
Time complexity: O(n) where n is lenght of the input string
Space: O(1) becuase at max we will have 26 characters."""

class Solution:
    def longestPalindrome(self, s: str) -> int:
        char_set = set()
        longest_palindrome_length = 0
        for char in s:
            if char not in char_set:
                char_set.add(char)
            else:
                char_set.remove(char)
                longest_palindrome_length +=2
        if char_set:
            longest_palindrome_length +=1
        return longest_palindrome_length