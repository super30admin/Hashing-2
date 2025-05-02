# Problem 3 : Longest Palindrome
# Time Complexity : O(n) where n is the length of the string s
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''
# Three line explanation of solution in plain english
'''
Hash set is used to track characters with odd count while scaning the string. For each character, if it's already in the set, it 
forms a pair, otherwise it's added to the set. After the loop, if any unpaired character remains, then it can be used as center
character then return result.
'''

# Your code here along with comments explaining your approach

class Solution:
    def longestPalindrome(self, s: str) -> int:
        # define hash set which will store the characters in the string s
        hashSet = set()
        # define variable result which will store the length of the longest palindrome
        result = 0
        # get the length of the string s
        length = len(s)
        # loop from 0 to length
        for i in range(length):
            # get the character of string s at ith position
            ch = s[i]
            # check if the character is present in hash set and if it is then add 2 to result and remove that character from hash set
            if ch in hashSet:
                result += 2
                hashSet.remove(ch)
            else:
                # else add that character to the hash set
                hashSet.add(ch)
        # check the length of the hash set nd if it is greater than 0 then increment the value of result
        if len(hashSet) > 0:
            result += 1
        # return result
        return result
