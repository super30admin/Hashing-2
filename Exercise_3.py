'''
409 Longest Palindrome
https://leetcode.com/problems/longest-palindrome/description/

Given a string s which consists of lowercase or uppercase letters, return the length of the longest that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.

Example 3:
Input: s = "Aa"
Output: -1
Explanation: Aa is not a palindrome

Constraints:
1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.

Solution:
1. From the input string of length N, generate all possible substrings of lengths 1 < len < N and check for palindrome.
Time: O(N^2), Space: O(1)

2. Hashing: Using a hashmap, save the character and the character count of the input string as key-value pairs. Then, retrieve all characters whose count is an even number. Then, retrieve the single character whose count is the largest odd number.
Time: O(N), Space: O(1)

'''

from collections import defaultdict

def longest_palindrome(s):
    if len(s) == 0:
        return -1

    if len(s) == 1:
        return 1

    h = defaultdict(int)
    for char in s: # Time: O(N), Space: O(52)
        h[char] += 1

    even = ""
    odd = ""
    for key in h: # Time: O(N) (worst case)
        if h[key] % 2 == 0:
            even += key*h[key]
        else:
            if h[key] > len(odd):
                odd = key*h[key]

    if len(even) == 0:
        return -1
    else:
        return len(even + odd)

def run_longest_palindrome():
    s = "abccccdd"
    l = longest_palindrome(s)
    print(f"string = {s}, len of longest possible palindrome = {l}")

    s = "abeeeccccdd"
    l = longest_palindrome(s)
    print(f"string = {s}, len of longest possible palindrome = {l}")

    s = "ddeegggg"
    l = longest_palindrome(s)
    print(f"string = {s}, len of longest possible palindrome = {l}")

    s = "a"
    l = longest_palindrome(s)
    print(f"string = {s}, len of longest possible palindrome = {l}")

    s = "abc"
    l = longest_palindrome(s)
    print(f"string = {s}, len of longest possible palindrome = {l}")

    s = "Aa"
    l = longest_palindrome(s)
    print(f"string = {s}, len of longest possible palindrome = {l}")

    s = ""
    l = longest_palindrome(s)
    print(f"string = {s}, len of longest possible palindrome = {l}")

run_longest_palindrome()
