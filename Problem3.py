class Solution(object):
    def longestPalindrome(self, s):
        """
        Time complexity: O(n)
        Space complexity: O(1) as 'n' can be atmost 52 characters 
        :type s: str
        :rtype: int
        """
        if s is None:
            return -1
        if len(s) == 1:
            return 1
        stringSet = set()  #set to store unique characters
        count = 0  # variable for the length of the palindrome
        for i in range(len(s)):
            c = s[i]  # Get the current character
            if c in stringSet:  # If the character is already in the set
                stringSet.remove(c)  # Remove it from the set
                count += 2  # Increment count by 2 since two matching characters are found
            else:
                stringSet.add(c)  # Otherwise, Add the character to the set

        if stringSet:  # If there are remaining characters in the set
            return count + 1  # Add one more character to the palindrome (can be placed in the middle)
        return count  # Returning the length of the longest palindrome
