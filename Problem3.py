# // Time Complexity : O(n)
# // Space Complexity : O(n) ( worst case all are unique and we store all elements)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        # find the longest palidrome possible with the letters in the string
        # logic: count the even letters in the str so that we can split them half number of that letters in the start adn half in the dn
        # and +1 for the odd element like for example abccccdd, the longest palindrome formed is ccdadcc 
        # (or any order of these letters it can also be dccbccd is also the longest palidrome both of lenght 7 
        # approach: have a set and while parsing thrugh the loop and if the element is occured again remove the letter from the set 
        # and increment the count of the longest palidrom ewith 2 and by the end if the set is not empty increase it with 1 

        hash_set = set()
        long_palindrome = 0

        for letter in s: # Tc : O(n)
            if letter in hash_set: # Tc search O(1)
                long_palindrome +=2 # Tc O(1)
                hash_set.remove(letter) # Tc remove O(1)
            else:
                hash_set.add(letter) # tc add O(1)

        
        if hash_set: # Tc  O(1)
            long_palindrome +=1

        return long_palindrome





