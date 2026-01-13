# Time Complexity : O(n) where n is the length of the string
# Space Complexity : O(1) since hashmap has at most 52 entries (uppercase and lowercase letters)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Count frequency of each character using a hashmap to track occurrences.
# For each character, add the largest even number of occurrences (count // 2 * 2) to the palindrome length.
# If any character has an odd count, add one more character to the center of the palindrome.

class Solution:
    def longestPalindrome(self, s: str) -> int:
        char_count = {}
        
        # Count frequency of each character
        for char in s:
            char_count[char] = char_count.get(char, 0) + 1
        
        length = 0
        odd_found = False
        
        # Calculate palindrome length
        for count in char_count.values():
            # Add largest even number of characters
            length += count // 2 * 2
            
            # Check if there's an odd count character for center
            if count % 2 == 1:
                odd_found = True
        
        # Add one center character if any odd count exists
        if odd_found:
            length += 1
        
        return length

