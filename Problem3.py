#Time Complexity : O(n)
#Space Complexity : O(1)
#Any problem you faced while coding this :none
#Your code here along with comments explaining your approach
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        my_hashSet=set() # to store any odd number of characters
        length=0
        for char in s:
            if char not in my_hashSet: # is it not in the hashset add it
                my_hashSet.add(char)
            else:                     # if it is already present then increment the length and remove it from the hasset as it even number 
                length+=2
                my_hashSet.remove(char)
        if len(my_hashSet):          # check if there are any odd number of character, if yes then increment the length of the palindrome by one 
            length+=1                
        return length
