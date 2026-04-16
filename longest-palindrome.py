# time O(n)
# space O(1) - number of unique characters, 52 chars max upper and lower case

# Track the duplicate characters in the string. If the char is in the set, add 2, remove the char, we've found a pair. 
# otherwise add the char to the set
# so we count by duplicates in the loop, adding 2 for each duplicate found. 
# then for a palindrome there can be 1 more char in the middle, so add 1 at end if any chars remain in the set
class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = 0
        unmatchedChars = set()

        for char in s: 
            if char in unmatchedChars:
                count += 2
                unmatchedChars.remove(char)
            else:
                unmatchedChars.add(char)


        if len(unmatchedChars) > 0:
            count += 1


        return count