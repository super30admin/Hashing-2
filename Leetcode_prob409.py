#problem: Longest Palindrome
#time complexity: O(n)
#space complexity: O(1)
#approach: using hashset to store the characters, if the character is already in the hashset, we remove it and increase the count by 2, if the character is not in the hashset, we add it to the hashset. In the end, if the hashset is not empty, we increase the count by 1.
class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = 0
        palindrome_char = set()

        for char in s:
            if char in palindrome_char:
                count += 2
                palindrome_char.remove(char)
            else:
                palindrome_char.add(char)
        if palindrome_char:
            count += 1

        return count
