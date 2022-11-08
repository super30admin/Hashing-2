class Solution:
    """
    Time complexity - O(n) n - length of s.
    Space complexity - O(1)
    """
    def longestPalindrome(self, s: str) -> int:
        char_count = [0 for x in range(0,52)]
        for c in s:
            index = ord(c)-71 if c.islower() else ord(c)-65
            char_count[index] += 1
        # check if a char is present odd number of times
        odd_present = False
        even_sum = 0
        for i in range(0,52):
            x = char_count[i]
            if x % 2 == 0:
                even_sum += x
            else:
                even_sum += x-1
                odd_present = True
        # A char of size 1 can be added at the middle of palindrome
        return even_sum+1 if odd_present else even_sum
            
        