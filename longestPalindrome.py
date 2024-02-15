"""
iterate over the charectors in the string s
if the char is not present in the hashset, add the element
if present increment coutner by 2 and remove the char, since this will be the second instance of the same char and can be sued in the palindrome
at the end check if the hashset is not empty; 
if not empty we can add any one char from that as the misddle char in the palindrome and hence increment count by 1

"""


class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = 0
        hashset = set()
        for i in range(len(s)):
            c = s[i]
            if c in hashset:
                count += 2
                hashset.remove(c)
            else:
                hashset.add(c)
        if len(hashset) != 0:
            count += 1
        return count
