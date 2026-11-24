#Analysis: Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

# We are basically using a frequency map here to count the characters. so when the frequency is even then we use all the characters when the frequency is odd then we just use it once.

# Time complexity: O(n)

#space complexity: O(n)

class Solution:
    def longestPalindrome(self, s: str) -> int:
        map = {}
        count = 0
        flag = False
        for i in s:
            map[i] = map.get(i, 0) + 1
        for val in map.values():
            if val % 2 == 0:
                count += val
            else:
                count += (val - 1)
                flag = True
        return count + 1 if flag else count
