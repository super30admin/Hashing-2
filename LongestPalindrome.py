# Time Complexity : O(n) where n is the number of char present in the string
# Space Complexity : O(n) where n is the number of unique char present in the string at the worst case
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:

    def longestPalindrome(self, s: str) -> int:

        #We create a set to store unique elements and access in O(1) time
        hashSet = set()
        longP = 0

        for char in s:
            #If char already present in the hashSet we will remove it from the set and add 2 to our tottal count
            if str(char) in hashSet:
                hashSet.remove(str(char))
                longP += 2
            else:
                #else we will add it to the hashSet
                hashSet.add(str(char))


        #If length of the hashSet == 0 means, we have pair of unique characters, whose length is the longP
        #else if anything left out in the hashSet it means we have one char left to add to our palindrome
        if len(hashSet) == 0:
            return longP
        else:

            return longP + 1
