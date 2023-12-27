#Time Complexity (TC): O(n)
#Space Complexity (SC): O(1)

class Solution:
    def longestPalindrome(self, s: str) -> int:
        char_dict = dict()  # Dictionary to store the count of each character in the str1

        for i in s:
            if i not in char_dict:
                char_dict[i] = 0
            char_dict[i] += 1

        all_values = list(char_dict.values())
        one_character = 0
        max_length = 0

        for i in all_values:
            if i % 2 == 0:
                # If it's even, directly add that value to the longest palindrome string
                max_length += i
            else:
                # If it's not even, then add (value - 1), which is even again
                max_length += (i - 1)
                one_character = 1  # One character which is in the middle of the palindrome string

        return max_length + one_character
