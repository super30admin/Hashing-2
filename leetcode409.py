#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Feb 10 21:21:02 2026

@author: rishigoswamy


    Problem: Longest Palindrome
    Link: https://leetcode.com/problems/longest-palindrome/

    Description:
    Given a string s consisting of uppercase and lowercase letters,
    return the length of the longest palindrome that can be built
    with those letters.

    Approach:
    Use a HashSet to track characters with odd frequency.

    - If a character appears twice, it contributes +2 to length.
    - Characters left in the set at the end have odd frequency.
    - We can place exactly one odd-frequency character in the center.

    Time Complexity: O(n)
    Space Complexity: O(1)  # At most 52 characters (A-Z, a-z)
    """

class Solution:
    def longestPalindrome(self, s: str) -> int:
        hSet = set()
        length = 0
        for char in s:
            if char in hSet:
                length += 2
                hSet.remove(char)
            else:
                hSet.add(char)
        
        return length + (1 if len(hSet) > 0 else 0)