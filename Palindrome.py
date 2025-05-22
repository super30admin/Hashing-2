#Time Complexity : O(N)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

#Approach:  Count the frequency of each character using a hash map. Add the even parts of each count to the length, 
# and if any character has an odd frequency, allow one to be the center of the palindrome.


from collections import defaultdict

class Solution(object):

    
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        freq_dict = defaultdict(int)

        # Count the frequency of each character
        for char in s:
            freq_dict[char] += 1

        length = 0
        odd_found = False

        # Calculate the length of the longest palindrome
        for count in freq_dict.values():
            length += (count // 2) * 2
            if count % 2 == 1:
                odd_found = True

        # Add one if there was at least one odd count (center character)
        if odd_found:
            length += 1

        return length