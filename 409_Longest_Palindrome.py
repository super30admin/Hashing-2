'''

## Problem 409: Longest Palindrome

## Author: Neha Doiphode
## Date:   07-01-2022

## Description
    Given a string s which consists of lowercase or uppercase letters,
    return the length of the longest palindrome that can be built with those letters.
    Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

## Examples:
    Example 1:
        Input: s = "abccccdd"
        Output: 7
        Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

    Example 2:
        Input: s = "a"
        Output: 1
        Explanation: The longest palindrome that can be built is "a", whose length is 1.

## Constraints:
    1 <= s.length <= 2000
    s consists of lowercase and/or uppercase English letters only.

## Time complexity: O(n), we need to traverse the string once to store counts.
## Space complexity: O(1), Overall, since character in the string are going to be constant.
                        But we would need some auxiliary space maybe O(log n) to store counts for each character.

'''

def get_input():
    print("Enter the input string: ", end = "")
    s = input()
    return s

class Solution:
    def longestPalindrome(self, s: str) -> int:
        character_count_map = {}

        for char in s:
            if char not in character_count_map:
                character_count_map[char] = 0
            character_count_map[char] += 1

        longest_palindrome = 0
        odd = 0
        for key, value in character_count_map.items():
            if value%2 == 0:
                longest_palindrome += value

            else:
                longest_palindrome += (value - 1)
                odd = 1

        return longest_palindrome + odd

# Driver code
s = get_input()
solution = Solution()
print()
print(f"Original string: {s}")
print(f"Longest palindrome length: {solution.longestPalindrome(s)}")
