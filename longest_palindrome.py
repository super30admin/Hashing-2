'''
We check whether character present in the set. If present we add 2 to length and remove from the set.
In the end if still we have characters in set, we add odd occurance of some characters.
So, we return length+1 or else just length when the set is empty.

Time Complexity: O(n)
Space Complexity: O(n)
'''

class Solution:
    def longestPalindrome(self, s: str) -> int:
        mySet = set()
        length = 0
        for char in s:
            if char not in mySet:
                mySet.add(char)
            else:
                length += 2
                mySet.remove(char)
                
        return length + 1 if mySet else length