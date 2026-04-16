# Time Complexity --> O(n)
# Space Complexity --> O(1)
# Approach --> We maintain a hashset which will have new characters added to it if not available. If already there, then we add 2 to the output and remove that character from the hashset. At the end, if there is atleast 1 character left in the hashset we can add 1 to output and return it.
class Solution:
    def longestPalindrome(self, s: str) -> int:
        hset = set()
        op = 0
        for i in range(len(s)):
            if s[i] not in hset:
                hset.add(s[i])
            else:
                op = op+2
                hset.remove(s[i])
        if len(hset)>0:
            op = op+1
        return op 

