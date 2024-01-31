'''
Time Complexity - O(n), we iterate the string 
Space Complexity - O(1), It will depend on the alphabetical characters and that does not go beyond 52

This code works on leetcode 
'''
class Solution:
    def longestPalindrome(self, s: str) -> int:
        if len(s) == 0:
            return 0
        hashSet = set()
        maxSize = 0
        for ch in s:
            if ch in hashSet: #check for the character in hashSet
                maxSize = maxSize+2 #if character is present we increase the count by 2 because we have a pair
                hashSet.remove(ch) #remove the character from the hashSet
            else:
                hashSet.add(ch) #else we add the character to the hashSet
        if hashSet: #We can increase the length by 1(odd number) if we have any characters in the hashSet
            maxSize = maxSize+1 
        return maxSize #return the maxSize
        