# https://leetcode.com/problems/longest-palindrome

# Use 'set' to store the characters. Used the variable to keep the count of the characters. Iterate over the string if the character is repeating then increase the counter by 2 and remove it from the set. At the end check if there anything in the set. If set has anything then increase the counter by 1. 
# Time Complexity- O(n) Space Complexity- O(1)

class Solution:
    def longestPalindrome(self, s:str)-> int:
        # initialise the empty set
        set_chars = set()
        # initilsie the counter 
        count = 0
        # iterate over the string 
        for char in s:
            # if the char is already present in the set
            if char in set_chars:
                # we got the pair increase the counter
                count += 2  
                # remove it from the set
                set_chars.remove(char)
            # if not present add into the set
            else:
                set_chars.add(char)
        #  if set has any single character, means we got the middle character in palindrome 
        if len(set_chars) > 0:
            # increase by 1
            return count + 1
        return count

solution = Solution()
print(solution.longestPalindrome("abccccdd"))
print(solution.longestPalindrome("abaa"))
