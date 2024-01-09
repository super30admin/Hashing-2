## Problem3 (https://leetcode.com/problems/longest-palindrome)
class Solution:
    def longestPalindrome(self, s: str) -> int:
        alphaSet = set()
        longestPalLength = 0
        for i in s:
            if i not in alphaSet:
                alphaSet.add(i)
            else:
                alphaSet.remove(i)
                longestPalLength += 2
        if alphaSet:
            longestPalLength += 1
        return longestPalLength

#maintain a set that tracks the alphabets
#if there is no existing element in set, push into the set
#else pop the element and increment the counter by 2 which states that first and last element of string are same
#finally check whether the set is empty or not. if it is not empty, it indicates that there are elements with single occurence
#increment the counter by 1, since we can consider one element which results in palindrome with odd length
#time complexity O(n)
#space complexity O(1)