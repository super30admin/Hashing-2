## Problem3 (https://leetcode.com/problems/longest-palindrome)

# Time Complexity : O(n)
# Space Complexity : O(k)  where k is the number of unique character because the k is constant space would become O(1)
# Did this code successfully run on Leetcode : YES

# Your code here along with comments explaining your approach
# 1. Characters that appear an even number of times can be fully used in a palindrome.
# 2. Characters that appear an odd number of times can have (count-1) characters used, which makes them even.
# 2. Additionally, we can place exactly one character with odd frequency in the middle of the palindrome.

def longestPalindrome(s):
    freq = {}
    res = 0

    # Count the frequency of each character in the string
    # and storing it in a dictionary
    for ch in s:
        if ch in freq:
            freq[ch] += 1
        else:
            freq[ch] = 1
    

    # Flag so that later when True the center odd subsection can be counted for
    has_odd = False
    # Calculate the length of the longest palindrome
    for ch in freq:
        if freq[ch] % 2 == 1:
            # For characters with odd freq, use (freq-1) characters
            # and potentially use the remaining one as the center
            res += freq[ch] - 1
            has_odd = True
        else:
            # For characters with even count, use all characters
            res += freq[ch]

    # If there's at least one character with odd frequency,
    # we can use one of them in the middle of the palindrome
    if has_odd: res += 1

    return res


s = "abccccdd"
longestPalindrome(s)