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

2. Hashing using hash map: Using a hash map, save the character and the character count of the input string as key-value pairs. Then, retrieve all characters whose count is an even number. Then, retrieve the single character whose count is the largest odd number.
Time: O(N), Space: O(1)

3. Hashing using hash set (better solution): For each character in the string, check if the char is present in hash set or not. If it is already present, it means we are encountering this character for the even-th time. Hence, add 2 to the length of palindrome and remove this character. If the character is not already present, it means we are encountering this character for the odd-th time. This doesn't contribute to the palindrome, hence dont increment the length of the palindrome.
Once we have made one pass through all the characters, the hash set may or may not have any characters left. If any character is present in the hash set, then it means that character has occurred in the string an odd no. of times. Hence, we can pick any one character from the hash set to form an odd-length palindrom. Thus, we increase the length of palindrome by 1. If the hash set doesn't have any character, then it means there were no characters with odd frequency counts. Hence, the palindrome must be an even-length palindrome. Hence,  we do not increase the length of palindrome by 1.

https://youtu.be/Oepp2HQ7134?t=3994

Time: O(N), Space: O(1)
'''

from collections import defaultdict

def longest_palindrome_hashmap(s):
    N = len(s)
    if N == 0:
        return 0
    h = defaultdict(int)
    even, odd = 0, 0
    odd_present = False
    for c in s:
        h[c] += 1

    for c in h:
        if h[c] % 2 == 0:
            even += h[c]
        else:
            # pick the closest even no. smaller than the odd freq count
            # eg. if there are three c, pick 2 c.
            # if there are five e, pick 4 e.
            odd += h[c] - 1  # even number
            odd_present = True

    # add 1 to the count to a/c for the char
    # with odd freq count.
    # Note: Only one odd char, out of all odd chars,
    # is allowed inside the palindrome with its odd freq count.
    # The remaining odd chars are allowed only with even freq count.
    if odd_present:
        count = even + odd + 1
    else:
        count = even
    return count


def longest_palindrome_hashset(s):
    N = len(s)
    if N == 0:
        return 0
    h = set()
    even = 0
    for c in s:
        if c not in h:
            h.add(c)
        else:
            even += 2
            h.remove(c)

    count = even

    # if hash set is not empty, it must be
    # having characters with odd freq count (say K)
    # We have already counted the closest even no. (K-1).
    # Hence, just add 1 to the count.
    if h:
        count += 1

    return count


def run_longest_palindrome():
    s = "abccccdd"
    l1 = longest_palindrome_hashmap(s)
    l2 = longest_palindrome_hashset(s)
    ans = 7
    print(f"string = {s}, len of longest possible palindrome = {l1, l2}, answer = {ans}")

    s = "abeeeccccddfffff" # 1a, 1b, 3e, 4c, 2d, 5f
    l1 = longest_palindrome_hashmap(s)
    l2 = longest_palindrome_hashset(s)
    ans = 13 # 4c + 2d + 3e + 4f || 4c + 2d + 2e + 5f
    print(f"string = {s}, len of longest possible palindrome = {l1, l2}, answer = {ans}")

    s = "ddeegggg"
    l1 = longest_palindrome_hashmap(s)
    l2 = longest_palindrome_hashset(s)
    ans = 8
    print(f"string = {s}, len of longest possible palindrome = {l1, l2}, answer = {ans}")

    s = "a"
    l1 = longest_palindrome_hashmap(s)
    l2 = longest_palindrome_hashset(s)
    ans = 1
    print(f"string = {s}, len of longest possible palindrome = {l1, l2}, answer = {ans}")

    s = "abc"
    l1 = longest_palindrome_hashmap(s)
    l2 = longest_palindrome_hashset(s)
    ans = 1
    print(f"string = {s}, len of longest possible palindrome = {l1, l2}, answer = {ans}")

    s = "ccc"
    l1 = longest_palindrome_hashmap(s)
    l2 = longest_palindrome_hashset(s)
    ans = 3
    print(f"string = {s}, len of longest possible palindrome = {l1, l2}, answer = {ans}")

    s = "Aa"
    l1 = longest_palindrome_hashmap(s)
    l2 = longest_palindrome_hashset(s)
    ans = 1
    print(f"string = {s}, len of longest possible palindrome = {l1, l2}, answer = {ans}")

    s = ""
    l1 = longest_palindrome_hashmap(s)
    l2 = longest_palindrome_hashset(s)
    ans = 0
    print(f"string = {s}, len of longest possible palindrome = {l1, l2}, answer = {ans}")

run_longest_palindrome()
